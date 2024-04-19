package lista;

import segreteria.Studente;

public class Lista {
    private int dim;
    private Studente[] studenti;
    private int count = 0;

    public void setDim(int dim) {
        this.dim = dim;
    }

    public void creaLista() {
        studenti = new Studente[dim];
    }

    public boolean inserisciElemento(String nome, String cognome, int matricola) {
        if(count< dim){
            studenti[count]= new Studente(matricola, nome, cognome);
            count++;
            return true;
        } else{
            return false;
        }
    }

    public void stampaLista() {
        // for (Studente studente : studenti) {
        //     System.out.println(studente.matricola + " " + studente.nome + " " + studente.cognome);
        //
        for(int i = 0; i< count;i++){
            System.out.println(studenti[i].matricola + " " + studenti[i].nome + " " + studenti[i].cognome);
        }
    }

}
