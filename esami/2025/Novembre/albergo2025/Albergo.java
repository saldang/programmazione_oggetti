package esame.albergo2025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Albergo {
    private final String nome;
    private final List<Camera> camere;
    private final List<Prenotazione> prenotazioni;

    public Albergo(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Il nome dell'albergo non può essere vuoto");
        }
        this.nome = nome.trim();
        this.camere = new ArrayList<>();
        this.prenotazioni = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiCamera(Camera camera) {
        if (camera == null) {
            throw new IllegalArgumentException("La camera non può essere null");
        }
        camere.add(camera);
    }

    public Camera cercaCameraDisponibile(int ospiti) {
        return camere.stream()
                .filter(camera -> !camera.isPrenotata() && camera.getMaxOspiti() >= ospiti)
                .findFirst()
                .orElse(null);
    }

    public Optional<Camera> trovaCameraPerNumero(int numero) {
        return camere.stream().filter(c -> c.getNumero() == numero).findFirst();
    }

    public Prenotazione creaPrenotazione(Cliente cliente, Camera camera, int giorni)
            throws CameraOccupatException, ClienteNonValidoException {
        if (cliente == null || camera == null) {
            throw new IllegalArgumentException("Cliente e camera devono essere specificati");
        }
        if (!camere.contains(camera)) {
            throw new IllegalArgumentException("La camera non appartiene a questo albergo");
        }
        if (giorni <= 0) {
            throw new IllegalArgumentException("I giorni devono essere positivi");
        }
        cliente.valida();
        camera.prenota(cliente);
        LocalDate dataInizio = LocalDate.now();
        LocalDate dataFine = dataInizio.plusDays(giorni);
        double costoTotale = camera.calcolaCosto(giorni);
        Prenotazione prenotazione = new Prenotazione(cliente, camera, dataInizio, dataFine, costoTotale);
        prenotazioni.add(prenotazione);
        return prenotazione;
    }

    public void liberaTutteLeCamere() {
        camere.forEach(Camera::libera);
    }

    public void visualizzaPrenotazioni() {
        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione registrata.");
            return;
        }
        prenotazioni.forEach(prenotazione -> System.out.println(prenotazione.toString()));
    }

    public void visualizzaTutteCamere() {
        camere.forEach(camera -> System.out.println(camera.visualizzaDettagli()));
    }

    public void salvaPrenotazioniSuFile(String nomeFile) throws FileAccessException {
        Path path = Paths.get(nomeFile);
        try {
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
        } catch (IOException e) {
            throw new FileAccessException("Impossibile creare le directory per il file: " + nomeFile, e);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(
                    "Nome;Cognome;Email;Telefono;DataRegistrazione;TipoCamera;NumeroCamera;DataInizio;DataFine;GiorniPrenotati;CostoTotale");
            writer.newLine();
            for (Prenotazione prenotazione : prenotazioni) {
                writer.write(prenotazione.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileAccessException("Errore durante il salvataggio delle prenotazioni", e);
        }
    }

    public void caricaPrenotazioniDaFile(String nomeFile) throws FileAccessException, FileNotFoundException {
        Path path = Paths.get(nomeFile);
        if (Files.notExists(path)) {
            throw new FileNotFoundException("File prenotazioni non trovato: " + nomeFile);
        }
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line = reader.readLine(); // header
            prenotazioni.clear();
            liberaTutteLeCamere();
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parti = line.split(";");
                if (parti.length < 11) {
                    continue;
                }
                try {
                    Cliente cliente = new Cliente(parti[0], parti[1], parti[2], parti[3], LocalDate.parse(parti[4]));
                    int numeroCamera = Integer.parseInt(parti[6]);
                    LocalDate dataInizio = LocalDate.parse(parti[7]);
                    LocalDate dataFine = LocalDate.parse(parti[8]);
                    double costo = Double.parseDouble(parti[10].replace(',', '.'));
                    Optional<Camera> cameraOpt = trovaCameraPerNumero(numeroCamera);
                    if (cameraOpt.isEmpty()) {
                        System.err.println("Camera numero " + numeroCamera + " non trovata, prenotazione ignorata.");
                        continue;
                    }
                    Camera camera = cameraOpt.get();
                    camera.libera();
                    camera.prenota(cliente);
                    Prenotazione prenotazione = new Prenotazione(cliente, camera, dataInizio, dataFine, costo);
                    prenotazioni.add(prenotazione);
                } catch (ClienteNonValidoException | CameraOccupatException | NumberFormatException e) {
                    System.err.println("Impossibile caricare la prenotazione: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new FileAccessException("Errore durante la lettura del file di prenotazioni", e);
        }
    }

    public List<Prenotazione> getPrenotazioni() {
        return new ArrayList<>(prenotazioni);
    }

    public List<Camera> getCamere() {
        return new ArrayList<>(camere);
    }
}
