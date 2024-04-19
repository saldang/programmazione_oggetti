package es1;

public class BankAccount {
    private double balance;

    // si costruisce un conto bancario con saldo uguale a zero
    private String password;

    /*
     * si costruisce un conto con saldo uguale a zero e password di accesso
     * numerica
     *
     * @param pass password numerica di accesso al conto
     */
    public BankAccount(String pass) {
        balance = 0;
        password = pass;
    }

    /*
     * si costruisce un conto con un saldo assegnato e password di accesso
     *
     * @param initialBalance il saldo iniziale
     *
     * @param pass password di accesso al conto
     */
    public BankAccount(double initialBalance, String pass) {
        balance = initialBalance;
        password = pass;
    }

    /*
     * si versa denaro nel conto bancario
     *
     * @param amount l'importo da versare
     */
    public void deposit(double amount, String pass) {
        if (controlloPassword(pass)) {
            balance = balance + amount;
            System.out.println("Versamento riuscito: Saldo attuale " + balance);
        } else {
            System.out.println("Versamento non riuscito, password errata");
        }
    }

    /*
     * si preleva denaro dal conto bancario
     *
     * @param amount l'importo da prelevare
     */
    public void withdraw(double amount, String pass) {
        if (controlloPassword(pass)) {

            if (controlloPrelievo(amount)) {
                balance = balance - amount;
                System.out.println("Prelievo riuscito: Saldo attuale " + balance);
            } else {
                System.out.println("Saldo inferiore al somma da prelevare");
            }
        } else {
            System.out.println("Prelievo non riuscito, password errata");
        }
    }

    /*
     * si applica un interesse sul conto
     *
     * @param rate il tasso d'interesse
     */
    public void addInterest(double rate) {
        balance = balance + ((balance * rate) / 100);
    }

    /*
     * ispeziona il valore del saldo attuale del conto bancario
     *
     * @return il saldo attuale
     */
    public double getBalance() {
        return balance;
    }

    /*
     * restituisce la password del conto
     *
     * @return la password del conto
     */
    public String getPassword() {
        return password;
    }

    /*
     * verifica la validità della password immessa
     *
     * @param pass la password da verificare
     *
     * @return true se corretta, false se errata
     */
    private boolean controlloPassword(String pass) {
        if (pass.equals(password))
            return true;
        return false;
    }

    /*
     * verifica che la somma da prelevare sia disponibile nel conto
     *
     * @param amount la somma da prelevare
     *
     * @return true se disponibile, false se non disponibile
     */
    private boolean controlloPrelievo(double amount) {
        if (amount <= balance)
            return true;
        return false;
    }
}
