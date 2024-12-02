
package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.GestioneUtenti;
import service.UtenteNonTrovatoException;
import model.*;

public class UI {
    private static GestioneUtenti gestioneUtenti = new GestioneUtenti();

    public static void main(String[] args) {
        // Creazione del frame principale
        JFrame frame = new JFrame("Gestione Utenti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Creazione del pannello principale
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Impostazione della visibilità del frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Etichetta e campo di testo per il nome utente
        JLabel userLabel = new JLabel("Nome:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Etichetta e campo di testo per l'email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 50, 165, 25);
        panel.add(emailText);

        // Etichetta e campo di testo per il ruolo
        JLabel roleLabel = new JLabel("Ruolo:");
        roleLabel.setBounds(10, 80, 80, 25);
        panel.add(roleLabel);

        JTextField roleText = new JTextField(20);
        roleText.setBounds(100, 80, 165, 25);
        panel.add(roleText);

        // Etichetta e campo di testo per lo stipendio
        JLabel salaryLabel = new JLabel("Stipendio:");
        salaryLabel.setBounds(10, 110, 80, 25);
        panel.add(salaryLabel);

        JTextField salaryText = new JTextField(20);
        salaryText.setBounds(100, 110, 165, 25);
        panel.add(salaryText);

        // Etichetta e campo di testo per la materia (solo per docenti)
        JLabel subjectLabel = new JLabel("Materia:");
        subjectLabel.setBounds(10, 140, 80, 25);
        panel.add(subjectLabel);

        JTextField subjectText = new JTextField(20);
        subjectText.setBounds(100, 140, 165, 25);
        panel.add(subjectText);

        // Etichetta e campo di testo per la classe (solo per studenti)
        JLabel classLabel = new JLabel("Classe:");
        classLabel.setBounds(10, 170, 80, 25);
        panel.add(classLabel);

        JTextField classText = new JTextField(20);
        classText.setBounds(100, 170, 165, 25);
        panel.add(classText);

        // Etichetta e campo di testo per la media voti (solo per studenti)
        JLabel gradeLabel = new JLabel("Media Voti:");
        gradeLabel.setBounds(10, 200, 80, 25);
        panel.add(gradeLabel);

        JTextField gradeText = new JTextField(20);
        gradeText.setBounds(100, 200, 165, 25);
        panel.add(gradeText);

        // Bottone per aggiungere un utente
        JButton addButton = new JButton("Aggiungi Utente");
        addButton.setBounds(10, 230, 150, 25);
        panel.add(addButton);

        // Bottone per cercare un utente
        JButton searchButton = new JButton("Cerca Utente");
        searchButton.setBounds(170, 230, 150, 25);
        panel.add(searchButton);

        // Area di testo per visualizzare i risultati
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 260, 450, 100);
        panel.add(resultArea);

        // Aggiunta di un'azione al bottone per aggiungere un utente
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = userText.getText();
                String email = emailText.getText();
                String ruolo = roleText.getText();
                double stipendio = Double.parseDouble(salaryText.getText());
                String materia = subjectText.getText();
                String classe = classText.getText();
                double mediaVoti = Double.parseDouble(gradeText.getText());

                if (!materia.isEmpty()) {
                    Docente docente = new Docente(nome, nome, email, ruolo, stipendio, materia);
                    gestioneUtenti.aggiungiUtente(docente);
                    resultArea.setText("Docente aggiunto: " + docente);
                } else if (!classe.isEmpty()) {
                    Studente studente = new Studente(nome, nome, email, classe, mediaVoti);
                    gestioneUtenti.aggiungiUtente(studente);
                    resultArea.setText("Studente aggiunto: " + studente);
                } else {
                    Dipendente dipendente = new Dipendente(nome, nome, email, ruolo, stipendio);
                    gestioneUtenti.aggiungiUtente(dipendente);
                    resultArea.setText("Dipendente aggiunto: " + dipendente);
                }
            }
        });

        // Aggiunta di un'azione al bottone per cercare un utente
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = userText.getText();
                try {
                    gestioneUtenti.cercaUtente(id);
                } catch (UtenteNonTrovatoException ex) {
                    resultArea.setText("Utente non trovato!");
                }
            }
        });
    }

}
