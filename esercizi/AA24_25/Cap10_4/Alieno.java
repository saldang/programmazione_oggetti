/*
Il seguente frammento di codice è stato progettato da J. Hacker per un video game. La classe Alieno rappresenta un mostro, mentre la classe GruppoAlieni rappresenta un gruppo di alieni e quanti danni questi possono infliggere. Le definizioni di tali classi sono fornite di seguito.
Il codice non è molto orientato agli oggetti e non supporta l’information hiding nella classe Alieno. Si riscriva il codice in modo da usare l’ereditarietà per rappresentare i differenti tipi di alieni al posto del parametro “tipo”. Si riscriva anche la classe Alieno per nascondere le variabili di istanza e per creare un metodo getDanno per ogni classe derivata e che restituisca il danno totale inflitto dall’alieno. Infine, si riscriva il metodo calcolaDanno e si scriva un metodo main che provi i codici.
*/

public class Alieno {

   private String nome;

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   private int salute;

   public int getSalute() {
      return salute;
   }

   public void setSalute(int salute) {
      this.salute = salute;
   }

   public Alieno(int salute, String nome) {
      this.salute = salute;
      this.nome = nome;
   }

   public int getDanno() {
      return 0;
   }
}
