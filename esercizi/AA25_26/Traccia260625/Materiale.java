public abstract class Materiale {
   String codice;
   String titolo;
   int annoPubblicazione;
   String genere;
   double prezzo;

   public Materiale(String codice, String titolo, int annoPubblicazione, String genere, double prezzo) {
      this.codice = codice;
      this.titolo = titolo;
      this.annoPubblicazione = annoPubblicazione;
      this.genere = genere;
      this.prezzo = prezzo;
   }

   @Override
   public boolean equals(Object obj) {
      return this.codice.equalsIgnoreCase(((Materiale) obj).codice);
   }

   @Override
   public String toString() {
      return codice + "," + titolo + "," + annoPubblicazione
            + "," + genere + "," + prezzo;
   }
}
