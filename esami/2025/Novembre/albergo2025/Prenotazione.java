package esame.albergo2025;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Objects;

public class Prenotazione {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    private final Cliente cliente;
    private final Camera camera;
    private final LocalDate dataInizio;
    private final LocalDate dataFine;
    private final int giorniPrenotati;
    private final double costoTotale;

    public Prenotazione(Cliente cliente, Camera camera, LocalDate dataInizio, LocalDate dataFine, double costoTotale) {
        this.cliente = Objects.requireNonNull(cliente, "Il cliente non può essere null");
        this.camera = Objects.requireNonNull(camera, "La camera non può essere null");
        this.dataInizio = Objects.requireNonNull(dataInizio, "La data di inizio non può essere null");
        this.dataFine = Objects.requireNonNull(dataFine, "La data di fine non può essere null");
        if (dataFine.isBefore(dataInizio)) {
            throw new IllegalArgumentException("La data di fine deve essere successiva alla data di inizio");
        }
        this.giorniPrenotati = (int) Math.max(1, ChronoUnit.DAYS.between(dataInizio, dataFine));
        this.costoTotale = costoTotale;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Camera getCamera() {
        return camera;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public int getGiorniPrenotati() {
        return giorniPrenotati;
    }

    public double getCostoTotale() {
        return costoTotale;
    }

    public String toCsv() {
        return String.join(";",
                cliente.getNome(),
                cliente.getCognome(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDataRegistrazione().toString(),
                camera.getClass().getSimpleName(),
                Integer.toString(camera.getNumero()),
                dataInizio.format(DATE_FORMAT),
                dataFine.format(DATE_FORMAT),
                Integer.toString(giorniPrenotati),
                String.format(Locale.ROOT, "%.2f", costoTotale));
    }

    @Override
    public String toString() {
        return cliente.getNome() + " " + cliente.getCognome()
                + " - " + camera.getClass().getSimpleName() + " N. " + camera.getNumero()
                + " - €" + String.format(Locale.ROOT, "%.2f", costoTotale)
                + " per " + giorniPrenotati + (giorniPrenotati == 1 ? " giorno" : " giorni");
    }
}
