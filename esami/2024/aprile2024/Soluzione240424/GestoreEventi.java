package Soluzione240424;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GestoreEventi {

    private SicurezzaCasa sicurezzaCasa;
    private List<Evento> eventi;
    private final Logger logger = new Logger(LocalDate.now().toString());

    public GestoreEventi(SicurezzaCasa sicurezzaCasa) {
        this.sicurezzaCasa = sicurezzaCasa;
        this.eventi = new ArrayList<Evento>();
    }

    public void leggiEventi() {
        // Leggo eventi da file eventi.csv che contiene una lista di eventi con il
        // formato: tipo evento, data, ora
        try {
            BufferedReader reader = new BufferedReader(new FileReader("eventi.csv"));
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split(",");
                Evento evento = new Evento(values[0], values[1], values[2]);
                eventi.add(evento);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        for (Evento evento : eventi) {
            registraEvento(evento);
            boolean eventoRilevato = false;
            for (Sensore sensore : sicurezzaCasa.getSensori()) {
                if (sensore.rilevaEvento(evento)) {
                    if (sicurezzaCasa.getAllarme().getStato()) {
                        sicurezzaCasa.getAllarme().suona();
                        eventoRilevato = true;
                        logger.writeToLogFile("Evento rilevato: " + evento.toString() + " dal sensore: "
                                + sensore.toString() + "Allarme attivo!");
                    } else {
                        logger.writeToLogFile("Evento rilevato: " + evento.toString() + " dal sensore: "
                                + sensore.toString() + "Allarme non attivo!");
                        System.out.println("Evento rilevato: " + evento.toString() + " dal sensore: "
                                + sensore.toString() + "Allarme non attivo!");
                    }
                    break;
                }

            }
            if (eventoRilevato) {
                break;
            }

        }
    }

    public void registraEvento(Evento evento) {
        logger.writeToLogFile(evento.toString());
    }
}
