# Dettaglio Approfondito: Moduli 6-9

## MODULO 6: Concetti OOP Avanzati (2 settimane)

### **Settimana 12: Composizione vs Ereditarietà**

#### Teoria: Relazione has-a

La composizione rappresenta una relazione "ha un" tra classi, diversamente dall'ereditarietà che rappresenta "è un". È uno dei principi più importanti del design OOP moderno.

**Esempio problema - Ereditarietà sbagliata:**

```java
public class Auto extends Motore {
    // SBAGLIATO: Auto NON è un Motore!
    // Auto HA UN motore
}
```

**Soluzione corretta - Composizione:**

```java
public class Auto {
    private Motore motore;
    private String marca;
    private int anno;

    public Auto(String marca, Motore motore) {
        this.marca = marca;
        this.motore = motore;
    }

    public void avvia() {
        motore.accendi();
    }

    public void spegni() {
        motore.spegni();
    }

    public void accelera() {
        motore.aumentaGiri(500);
    }
}

public class Motore {
    private int potenza;
    private int giri;

    public void accendi() {
        System.out.println("Motore acceso");
    }

    public void spegni() {
        System.out.println("Motore spento");
    }

    public void aumentaGiri(int delta) {
        this.giri += delta;
    }
}
```

#### Delegation Pattern

Il delegation consente a un oggetto di delegare responsabilità a un altro:

```java
public class Studente {
    private String nome;
    private Indirizzo indirizzo;  // Composizione

    public Studente(String nome, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    // Delegation: delego al Indirizzo
    public String getCitta() {
        return indirizzo.getCitta();
    }

    public void cambiaIndirizzo(Indirizzo nuovoIndirizzo) {
        this.indirizzo = nuovoIndirizzo;
    }
}

public class Indirizzo {
    private String via;
    private String citta;
    private String cap;

    public Indirizzo(String via, String citta, String cap) {
        this.via = via;
        this.citta = citta;
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public String getCompleto() {
        return via + ", " + citta + " " + cap;
    }
}
```

#### Comparazione: Quando usare cosa

**Usa Ereditarietà quando:**

- Esiste una vera relazione "è un"
- Condividi codice comune da una classe base
- Vuoi polimorfismo su una gerarchia
- Esempio: Cane è un Animale, triangolo è una Forma

**Usa Composizione quando:**

- La relazione è "ha un"
- Vuoi più flessibilità (cambiare comportamento a runtime)
- Vuoi evitare gerarchie profonde
- Esempio: Auto ha un Motore, Persona ha un Indirizzo

```java
// ANTI-PATTERN: gerarchia profonda
public class Veicolo { }
public class Terrestre extends Veicolo { }
public class ConMotore extends Terrestre { }
public class Auto extends ConMotore { }

// MIGLIORE: composizione + poche classi
public class Veicolo {
    private Motore motore;
    private TipoTerreno terreno;
}
```

#### Esercizio Pratico 1: Sistema di Pagamento

```java
public class Ordine {
    private List<Prodotto> prodotti;
    private MetodoPagamento metodoPagamento;

    public void processa() {
        double totale = calcolaTotale();
        metodoPagamento.paga(totale);
    }

    // Posso cambiare il metodo di pagamento a runtime!
    public void setMetodoPagamento(MetodoPagamento metodo) {
        this.metodoPagamento = metodo;
    }
}

public interface MetodoPagamento {
    void paga(double importo);
}

public class CartaCredito implements MetodoPagamento {
    private String numero;

    @Override
    public void paga(double importo) {
        System.out.println("Pagamento " + importo + " su carta");
    }
}

public class PayPal implements MetodoPagamento {
    private String email;

    @Override
    public void paga(double importo) {
        System.out.println("Pagamento " + importo + " via PayPal");
    }
}

// Uso
Ordine ordine = new Ordine();
ordine.setMetodoPagamento(new CartaCredito("1234"));
ordine.processa();

ordine.setMetodoPagamento(new PayPal("user@email.com"));
ordine.processa();
```

---

### **Settimana 13: Encapsulation e Principi SOLID**

#### Single Responsibility Principle (SRP)

Una classe deve avere una sola ragione per cambiare. Ogni classe deve avere una sola responsabilità.

**Anti-pattern:**

```java
public class Studente {
    private String nome;
    private List<Esame> esami;

    public void aggiungiEsame(Esame esame) { /* ... */ }

    // SBAGLIATO: responsabilità multiple!
    public void salvasuDB() { /* connessione DB */ }
    public void inviaMail() { /* invio email */ }
    public void stampaRapporto() { /* generazione report */ }
}
```

**Corretto:**

```java
// Responsabilità 1: gestire i dati dello studente
public class Studente {
    private String nome;
    private List<Esame> esami;

    public void aggiungiEsame(Esame esame) { /* ... */ }
    public double getMedia() { /* ... */ }
}

// Responsabilità 2: persistenza
public class StudenteRepository {
    public void salva(Studente studente) { /* DB */ }
    public Studente carica(String id) { /* DB */ }
}

// Responsabilità 3: notifiche
public class EmailService {
    public void inviaMail(Studente s, String messaggio) { /* ... */ }
}

// Responsabilità 4: report
public class RapportoGenerator {
    public String genera(Studente s) { /* ... */ }
}

// Uso
Studente studente = new Studente();
StudenteRepository repo = new StudenteRepository();
repo.salva(studente);

EmailService email = new EmailService();
email.inviaMail(studente, "Benvenuto!");
```

#### Open-Closed Principle (OCP)

Una classe deve essere aperta per l'estensione, ma chiusa per la modifica.

**Anti-pattern:**

```java
public class Sconto {
    public double calcola(String tipoCliente, double importo) {
        if (tipoCliente.equals("REGULAR")) {
            return importo * 0.05;
        } else if (tipoCliente.equals("VIP")) {
            return importo * 0.10;
        } else if (tipoCliente.equals("PREMIUM")) {
            return importo * 0.20;
        }
        // Ogni nuovo tipo di cliente richiede modifica della classe!
        return 0;
    }
}
```

**Corretto:**

```java
public interface CalcoloSconto {
    double calcola(double importo);
}

public class ScontoRegular implements CalcoloSconto {
    @Override
    public double calcola(double importo) {
        return importo * 0.05;
    }
}

public class ScontoVIP implements CalcoloSconto {
    @Override
    public double calcola(double importo) {
        return importo * 0.10;
    }
}

public class ScontoPremium implements CalcoloSconto {
    @Override
    public double calcola(double importo) {
        return importo * 0.20;
    }
}

// Per aggiungere nuovo sconto: creo nuova classe
// Nessuna modifica al codice esistente!
public class ScontoSpeciale implements CalcoloSconto {
    @Override
    public double calcola(double importo) {
        return importo * 0.30;
    }
}

// Uso
public class CarrelloSpesa {
    private CalcoloSconto sconto;

    public CarrelloSpesa(CalcoloSconto sconto) {
        this.sconto = sconto;
    }

    public double calcolaTotaleConSconto(double importo) {
        return importo - sconto.calcola(importo);
    }
}
```

#### Liskov Substitution Principle (LSP)

Gli oggetti di una sottoclasse devono poter essere utilizzati al posto di quelli della superclasse senza alterare il comportamento.

**Anti-pattern:**

```java
public class Rettangolo {
    protected int larghezza;
    protected int altezza;

    public void setLarghezza(int l) { this.larghezza = l; }
    public void setAltezza(int a) { this.altezza = a; }
    public int getArea() { return larghezza * altezza; }
}

public class Quadrato extends Rettangolo {
    @Override
    public void setLarghezza(int l) {
        // Viola LSP: comportamento inaspettato
        this.larghezza = l;
        this.altezza = l;
    }

    @Override
    public void setAltezza(int a) {
        this.larghezza = a;
        this.altezza = a;
    }
}

// Questo codice si rompe!
Rettangolo rettangolo = new Quadrato();
rettangolo.setLarghezza(5);
rettangolo.setAltezza(10);
assert rettangolo.getArea() == 50; // FALLISCE! Area è 100
```

**Corretto:**

```java
public abstract class Forma {
    abstract int getArea();
}

public class Rettangolo extends Forma {
    private int larghezza;
    private int altezza;

    public Rettangolo(int larghezza, int altezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    @Override
    public int getArea() {
        return larghezza * altezza;
    }
}

public class Quadrato extends Forma {
    private int lato;

    public Quadrato(int lato) {
        this.lato = lato;
    }

    @Override
    public int getArea() {
        return lato * lato;
    }
}

// Comportamento prevedibile e coerente
List<Forma> forme = Arrays.asList(
    new Rettangolo(5, 10),
    new Quadrato(5)
);

for (Forma f : forme) {
    System.out.println(f.getArea()); // Comportamento coerente
}
```

#### Interface Segregation Principle (ISP)

I client non devono dipendere da interfacce che non utilizzano. Meglio molte interfacce specifiche che una sola generica.

**Anti-pattern:**

```java
public interface Lavoratore {
    void lavora();
    void mangia();
    void riposa();
    void canta();
}

public class Umano implements Lavoratore {
    @Override
    public void lavora() { System.out.println("Lavoro"); }

    @Override
    public void mangia() { System.out.println("Mangio"); }

    @Override
    public void riposa() { System.out.println("Riposo"); }

    @Override
    public void canta() { System.out.println("Canto"); }
}

public class Robot implements Lavoratore {
    @Override
    public void lavora() { System.out.println("Lavoro"); }

    @Override
    public void mangia() { /* inutile */ }

    @Override
    public void riposa() { /* inutile */ }

    @Override
    public void canta() { /* inutile */ }
}
```

**Corretto:**

```java
public interface Lavoratore {
    void lavora();
}

public interface Consumatore {
    void mangia();
}

public interface Riposante {
    void riposa();
}

public interface Cantante {
    void canta();
}

public class Umano implements Lavoratore, Consumatore, Riposante, Cantante {
    @Override
    public void lavora() { System.out.println("Lavoro"); }

    @Override
    public void mangia() { System.out.println("Mangio"); }

    @Override
    public void riposa() { System.out.println("Riposo"); }

    @Override
    public void canta() { System.out.println("Canto"); }
}

public class Robot implements Lavoratore {
    @Override
    public void lavora() { System.out.println("Lavoro"); }
    // Solo quello che serve!
}
```

#### Dependency Inversion Principle (DIP)

Dipendi da astrazioni, non da implementazioni concrete. Le classi di alto livello non devono dipendere da quelle di basso livello.

**Anti-pattern:**

```java
public class NotificaEmail {
    public void invia(String destinatario, String messaggio) {
        // Implementazione concreta di email
    }
}

public class Ordine {
    private NotificaEmail email;  // Dipendenza da concreta!

    public Ordine() {
        this.email = new NotificaEmail();  // Tight coupling
    }

    public void conferma() {
        email.invia("user@email.com", "Ordine confermato");
    }
}
```

**Corretto:**

```java
public interface NotificaService {
    void invia(String destinatario, String messaggio);
}

public class NotificaEmail implements NotificaService {
    @Override
    public void invia(String destinatario, String messaggio) {
        System.out.println("Email inviata");
    }
}

public class NotificaSMS implements NotificaService {
    @Override
    public void invia(String destinatario, String messaggio) {
        System.out.println("SMS inviato");
    }
}

public class Ordine {
    private NotificaService notifica;  // Dipendenza da astrazione!

    public Ordine(NotificaService notifica) {
        this.notifica = notifica;  // Loose coupling
    }

    public void conferma() {
        notifica.invia("user@email.com", "Ordine confermato");
    }
}

// Uso flessibile
NotificaService email = new NotificaEmail();
Ordine ordine1 = new Ordine(email);
ordine1.conferma();

NotificaService sms = new NotificaSMS();
Ordine ordine2 = new Ordine(sms);
ordine2.conferma();
```

#### Strategy Pattern

Definisce una famiglia di algoritmi, incapsulali e rendili intercambiabili.

```java
public interface StrategiaOrdino {
    List<?> ordina(List<?> lista);
}

public class OrdinoPerNome implements StrategiaOrdino {
    @Override
    public List<?> ordina(List<?> lista) {
        // Ordinamento per nome
        return lista.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}

public class OrdinoPerData implements StrategiaOrdino {
    @Override
    public List<?> ordina(List<?> lista) {
        // Ordinamento per data
        return lista.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}

public class ListaOrdini {
    private StrategiaOrdino strategia;
    private List<?> ordini;

    public ListaOrdini(StrategiaOrdino strategia) {
        this.strategia = strategia;
    }

    public void ordina() {
        ordini = strategia.ordina(ordini);
    }

    public void setStrategia(StrategiaOrdino nuovaStrategia) {
        this.strategia = nuovaStrategia;
    }
}
```

#### Adapter Pattern

Converte l'interfaccia di una classe in un'altra interfaccia attesa dai client.

```java
// Sistema vecchio
public class SistemaVecchio {
    public String elabora(String dato) {
        return "Elaborato: " + dato;
    }
}

// Nuova interfaccia che mi serve
public interface ProcessareModerno {
    void processa(String input);
}

// Adapter
public class AdapterSistemaVecchio implements ProcessareModerno {
    private SistemaVecchio sistemaVecchio;

    public AdapterSistemaVecchio(SistemaVecchio vecchio) {
        this.sistemaVecchio = vecchio;
    }

    @Override
    public void processa(String input) {
        String risultato = sistemaVecchio.elabora(input);
        System.out.println(risultato);
    }
}

// Uso
SistemaVecchio vecchio = new SistemaVecchio();
ProcessareModerno adattato = new AdapterSistemaVecchio(vecchio);
adattato.processa("dati");
```

#### Esercizio Pratico 2: Sistema di Notifiche

Implementare un sistema di notifiche che rispetti SOLID:

```java
// Interfaccia segregata
public interface Notificatore {
    void notifica(String messaggio);
}

// Implementazioni concrete
public class NotificatoreEmail implements Notificatore {
    @Override
    public void notifica(String messaggio) {
        System.out.println("Email: " + messaggio);
    }
}

public class NotificatoreSMS implements Notificatore {
    @Override
    public void notifica(String messaggio) {
        System.out.println("SMS: " + messaggio);
    }
}

public class NotificatorePush implements Notificatore {
    @Override
    public void notifica(String messaggio) {
        System.out.println("Push: " + messaggio);
    }
}

// Servizio che invia notifiche
public class ServizioNotifiche {
    private List<Notificatore> notificatori;

    public ServizioNotifiche() {
        this.notificatori = new ArrayList<>();
    }

    public void aggiungiNotificatore(Notificatore n) {
        notificatori.add(n);
    }

    public void notificaTutti(String messaggio) {
        for (Notificatore n : notificatori) {
            n.notifica(messaggio);
        }
    }
}

// Uso
ServizioNotifiche servizio = new ServizioNotifiche();
servizio.aggiungiNotificatore(new NotificatoreEmail());
servizio.aggiungiNotificatore(new NotificatoreSMS());
servizio.aggiungiNotificatore(new NotificatorePush());

servizio.notificaTutti("Nuovo ordine ricevuto!");
```

---

## MODULO 7: Generics e Collections (2 settimane)

### **Settimana 14: Generics**

#### Problemi senza Generics

```java
// Senza generics: rischio di errori
List lista = new ArrayList();
lista.add("Ciao");
lista.add(123);
lista.add(new Persona("Mario"));

// Quando recupero, non so che tipo è!
for (Object obj : lista) {
    // Casting manuale e pericoloso
    String s = (String) obj;  // ClassCastException a runtime!
}
```

#### Introduzione ai Generics

```java
// Con generics: type-safe
List<String> lista = new ArrayList<>();
lista.add("Ciao");
// lista.add(123);  // ERRORE COMPILAZIONE
// lista.add(new Persona("Mario"));  // ERRORE COMPILAZIONE

// Quando recupero, so che tipo è
for (String s : lista) {
    System.out.println(s);  // Niente cast necessario
}
```

#### Dichiarazione di Classi Generiche

```java
// Classe generica con un parametro di tipo
public class Contenitore<T> {
    private T contenuto;

    public Contenitore(T contenuto) {
        this.contenuto = contenuto;
    }

    public T getContenuto() {
        return contenuto;
    }

    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }
}

// Uso
Contenitore<String> scatola1 = new Contenitore<>("Libro");
System.out.println(scatola1.getContenuto());  // "Libro"

Contenitore<Integer> scatola2 = new Contenitore<>(42);
System.out.println(scatola2.getContenuto());  // 42

Contenitore<Persona> scatola3 = new Contenitore<>(new Persona("Maria"));
System.out.println(scatola3.getContenuto());  // Persona
```

#### Classe Generica con Più Parametri

```java
public class Coppia<T, U> {
    private T primo;
    private U secondo;

    public Coppia(T primo, U secondo) {
        this.primo = primo;
        this.secondo = secondo;
    }

    public T getPrimo() { return primo; }
    public U getSecondo() { return secondo; }

    public void scambia() {
        // Non posso scambiare direttamente, tipi diversi
        // Ma posso creare nuova coppia invertita
    }
}

// Uso
Coppia<String, Integer> coppia1 = new Coppia<>("Mario", 30);
String nome = coppia1.getPrimo();
Integer eta = coppia1.getSecondo();

Coppia<Double, String> coppia2 = new Coppia<>(98.5, "Febbre");
```

#### Bounded Type Parameters

A volte vogliamo limitare quali tipi possono essere usati:

```java
// T deve essere Numero o sottoclasse
public class Calcolatore<T extends Number> {
    private T valore;

    public Calcolatore(T valore) {
        this.valore = valore;
    }

    public double quadrato() {
        return valore.doubleValue() * valore.doubleValue();
    }
}

// Uso
Calcolatore<Integer> calc1 = new Calcolatore<>(5);
System.out.println(calc1.quadrato());  // 25.0

Calcolatore<Double> calc2 = new Calcolatore<>(3.5);
System.out.println(calc2.quadrato());  // 12.25

// Calcolatore<String> calc3 = new Calcolatore<>("Ciao");
// ERRORE: String non estende Number
```

#### Interfaccia Generica con Bound

```java
public interface Comparabile<T> {
    int comparaCon(T altro);
}

public class Persona implements Comparabile<Persona> {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    @Override
    public int comparaCon(Persona altra) {
        return Integer.compare(this.eta, altra.eta);
    }
}

// Uso
Persona p1 = new Persona("Mario", 30);
Persona p2 = new Persona("Luigi", 25);
System.out.println(p1.comparaCon(p2));  // Positivo, p1 è più grande
```

#### Metodi Generici

```java
public class Utilita {
    // Metodo generico statico
    public static <T> void stampa(T elemento) {
        System.out.println(elemento);
    }

    // Metodo generico con bound
    public static <T extends Number> double quadrato(T numero) {
        double d = numero.doubleValue();
        return d * d;
    }

    // Metodo generico che lavora con liste
    public static <T> int contiamo(List<T> lista, T elemento) {
        int count = 0;
        for (T item : lista) {
            if (item.equals(elemento)) count++;
        }
        return count;
    }

    // Metodo generico per trovare massimo
    public static <T extends Comparable<T>> T massimo(List<T> lista) {
        if (lista.isEmpty()) return null;
        T max = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).compareTo(max) > 0) {
                max = lista.get(i);
            }
        }
        return max;
    }
}

// Uso
Utilita.<String>stampa("Ciao");
Utilita.<Integer>stampa(42);
Utilita.stampa("World");  // Type inference

System.out.println(Utilita.quadrato(5));  // 25.0
System.out.println(Utilita.quadrato(3.5));  // 12.25

List<Integer> numeri = Arrays.asList(5, 2, 8, 1);
System.out.println(Utilita.massimo(numeri));  // 8
```

#### Wildcard (?)

```java
// Wildcard senza limiti: accetta qualsiasi tipo
public static void stampaLista(List<?> lista) {
    for (Object obj : lista) {
        System.out.println(obj);
    }
}

// Uso
List<String> stringhe = Arrays.asList("A", "B", "C");
List<Integer> numeri = Arrays.asList(1, 2, 3);
stampaLista(stringhe);
stampaLista(numeri);

// Wildcard con upper bound: accetta sottoclassi
public static void stampaNumeri(List<? extends Number>) {
    // Posso leggere come Number
    // Ma non posso aggiungere (eccetto null)
}

List<Integer> interi = Arrays.asList(1, 2, 3);
stampaNumeri(interi);

// Wildcard con lower bound: accetta superclassi
public static void aggiungiNumeri(List<? super Integer> lista) {
    lista.add(10);
    lista.add(20);
}

List<Number> numeri2 = new ArrayList<>();
aggiungiNumeri(numeri2);
```

#### Erasure e Limitazioni dei Generics

```java
// IMPORTANTE: Type Erasure
// I generics sono rimossi a runtime (per compatibilità backward)

List<String> stringhe = new ArrayList<>();
List<Integer> interi = new ArrayList<>();

// A runtime sono UGUALI
System.out.println(stringhe.getClass() == interi.getClass());  // true

// NON puoi fare:
// new T()  - non conosco il tipo
// new T[10]  - non posso creare array di tipo generico
// T instanceof String  - non puoi fare instanceof con tipo generico

// Workaround: passare classe
public class Creatore<T> {
    private Class<T> classe;

    public Creatore(Class<T> classe) {
        this.classe = classe;
    }

    public T crea() throws Exception {
        return classe.getDeclaredConstructor().newInstance();
    }
}

Creatore<String> creatore = new Creatore<>(String.class);
String s = creatore.crea();
```

#### Esercizio Pratico 1: Stack Generico

```java
public class Stack<T> {
    private List<T> elementi;

    public Stack() {
        this.elementi = new ArrayList<>();
    }

    public void push(T elemento) {
        elementi.add(elemento);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementi.remove(elementi.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementi.get(elementi.size() - 1);
    }

    public boolean isEmpty() {
        return elementi.isEmpty();
    }

    public int size() {
        return elementi.size();
    }
}

// Uso
Stack<String> stack = new Stack<>();
stack.push("primo");
stack.push("secondo");
stack.push("terzo");

while (!stack.isEmpty()) {
    System.out.println(stack.pop());
}
```

#### Esercizio Pratico 2: Repository Generico

```java
public interface Repository<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(ID id);
}

public class InMemoryRepository<T, ID> implements Repository<T, ID> {
    private Map<ID, T> storage = new HashMap<>();

    @Override
    public void save(T entity) {
        // Semplificato per l'esempio
    }

    @Override
    public T findById(ID id) {
        return storage.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(ID id) {
        storage.remove(id);
    }
}

// Uso
Repository<Persona, String> repoPersone = new InMemoryRepository<>();
Repository<Prodotto, Integer> repoProdotti = new InMemoryRepository<>();
```

---

### **Settimana 15: Collections Framework**

#### Gerarchia Collections

```
Iterable
    └── Collection
        ├── List
        │   ├── ArrayList
        │   ├── LinkedList
        │   └── Vector (legacy)
        ├── Set
        │   ├── HashSet
        │   ├── LinkedHashSet
        │   └── TreeSet
        └── Queue
            ├── PriorityQueue
            └── Deque
Map
    ├── HashMap
    ├── LinkedHashMap
    ├── TreeMap
    └── Hashtable (legacy)
```

#### List Interface

```java
// List: ordine, permette duplicati, indiciato
List<String> lista = new ArrayList<>();

// Aggiungi
lista.add("primo");
lista.add("secondo");
lista.add("terzo");
lista.add(1, "inserito");  // inserisci in posizione

// Leggi
String primo = lista.get(0);
int indice = lista.indexOf("secondo");
// Modifica
lista.set(0, "modificato");

// Rimuovi
lista.remove(0);  // per indice
lista.remove("secondo");  // per valore

// Iterazione
for (String s : lista) {
    System.out.println(s);
}

for (int i = 0; i < lista.size(); i++) {
    System.out.println(lista.get(i));
}

// ArrayList vs LinkedList
ArrayList<Integer> al = new ArrayList<>();  // Accesso veloce, inserimento lento
LinkedList<Integer> ll = new LinkedList<>();  // Accesso lento, inserimento veloce
```

#### Set Interface

```java
// Set: NO ordine, NO duplicati
Set<String> set = new HashSet<>();

set.add("mela");
set.add("banana");
set.add("mela");  // Non aggiunge (è già presente)

System.out.println(set.size());  // 2

// Verifica contenimento
if (set.contains("mela")) {
    System.out.println("C'è mela");
}

// Rimuovi
set.remove("banana");

// Iterazione (ordine non garantito)
for (String frutto : set) {
    System.out.println(frutto);
}

// LinkedHashSet: mantiene ordine di inserimento
Set<String> linked = new LinkedHashSet<>();
linked.add("primo");
linked.add("secondo");
linked.add("terzo");
// Iterazione mantiene ordine: primo, secondo, terzo

// TreeSet: ordine naturale (ordinato)
Set<Integer> tree = new TreeSet<>();
tree.add(5);
tree.add(2);
tree.add(8);
tree.add(1);
// Iterazione in ordine: 1, 2, 5, 8

// Operazioni su Set
Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

// Unione
set1.addAll(set2);  // {1, 2, 3, 4, 5, 6}

// Intersezione
set1.retainAll(set2);  // {3, 4}

// Differenza
set1.removeAll(set2);  // rimuove elementi comuni
```

#### Map Interface

```java
// Map: coppie chiave-valore, no duplicati di chiave
Map<String, Integer> mappa = new HashMap<>();

// Aggiungi
mappa.put("Mario", 30);
mappa.put("Luigi", 25);
mappa.put("Peach", 28);

// Leggi
Integer eta = mappa.get("Mario");  // 30
Integer nonEsiste = mappa.get("Toad");  // null

// Verifica
if (mappa.containsKey("Luigi")) {
    System.out.println("Luigi esiste");
}

if (mappa.containsValue(25)) {
    System.out.println("Qualcuno ha 25 anni");
}

// Rimuovi
mappa.remove("Peach");

// Iterazione su chiavi
for (String nome : mappa.keySet()) {
    System.out.println(nome);
}

// Iterazione su valori
for (Integer eta : mappa.values()) {
    System.out.println(eta);
}

// Iterazione su coppie
for (Map.Entry<String, Integer> entry : mappa.entrySet()) {
    String nome = entry.getKey();
    Integer e = entry.getValue();
    System.out.println(nome + ": " + e);
}

// getOrDefault
Integer etaDefault = mappa.getOrDefault("Sconosciuto", 0);

// putIfAbsent: aggiungi solo se chiave non esiste
mappa.putIfAbsent("Mario", 50);  // Non aggiunge (Mario esiste)
mappa.putIfAbsent("Daisy", 27);  // Aggiunge

// LinkedHashMap: mantiene ordine di inserimento
Map<String, Integer> linked = new LinkedHashMap<>();
linked.put("primo", 1);
linked.put("secondo", 2);
linked.put("terzo", 3);
// Iterazione mantiene ordine di inserimento

// TreeMap: ordine di chiavi (ordinato)
Map<String, Integer> tree = new TreeMap<>();
tree.put("zebra", 1);
tree.put("apple", 2);
tree.put("banana", 3);
// Iterazione in ordine alfabetico: apple, banana, zebra
```

#### Iterazione e Stream

```java
List<String> nomi = Arrays.asList("Mario", "Luigi", "Peach");

// Iterazione tradizionale
for (int i = 0; i < nomi.size(); i++) {
    System.out.println(nomi.get(i));
}

// Enhanced for loop
for (String nome : nomi) {
    System.out.println(nome);
}

// Iterator
Iterator<String> iteratore = nomi.iterator();
while (iteratore.hasNext()) {
    System.out.println(iteratore.next());
}

// Stream (Java 8+)
nomi.stream()
    .forEach(System.out::println);

// Stream con filter
nomi.stream()
    .filter(n -> n.length() > 5)
    .forEach(System.out::println);

// Stream con map
nomi.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println);

// Stream con collect
List<String> uppercase = nomi.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// Stream con sorted
List<String> ordinati = nomi.stream()
    .sorted()
    .collect(Collectors.toList());
```

#### Sorting e Ordinamento

```java
// Comparable: implementare nella classe
public class Persona implements Comparable<Persona> {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    @Override
    public int compareTo(Persona altra) {
        // Ordina per età crescente
        return Integer.compare(this.eta, altra.eta);
    }

    @Override
    public String toString() {
        return nome + " (" + eta + ")";
    }
}

List<Persona> persone = new ArrayList<>(Arrays.asList(
    new Persona("Mario", 30),
    new Persona("Luigi", 25),
    new Persona("Peach", 28)
));

// Ordinamento con Comparable
Collections.sort(persone);
persone.forEach(System.out::println);
// Luigi (25), Peach (28), Mario (30)

// Comparator: ordinamento esterno
Comparator<Persona> perNome = Comparator.comparing(p -> p.getNome());
persone.sort(perNome);

// Comparator con metodo di riferimento
Comparator<Persona> perEta = Comparator.comparingInt(Persona::getEta);
persone.sort(perEta);

// Comparator invertito (decrescente)
persone.sort(perEta.reversed());

// Ordinamento multiplo
persone.sort(
    Comparator.comparingInt(Persona::getEta)
        .thenComparing(p -> p.getNome())
);

// Stream con sorted
persone.stream()
    .sorted(Comparator.comparingInt(Persona::getEta))
    .forEach(System.out::println);
```

#### Esercizio Pratico: Gestione Inventario

```java
public class Prodotto {
    private String id;
    private String nome;
    private int quantita;
    private double prezzo;

    public Prodotto(String id, String nome, int quantita, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantita() { return quantita; }
    public double getPrezzo() { return prezzo; }

    public void riduciQuantita(int qty) {
        this.quantita -= qty;
    }

    public void aumentaQuantita(int qty) {
        this.quantita += qty;
    }

    public double getValoreTotale() {
        return quantita * prezzo;
    }

    @Override
    public String toString() {
        return nome + ": " + quantita + " unità @ €" + prezzo;
    }
}

public class Inventario {
    private Map<String, Prodotto> prodotti;

    public Inventario() {
        this.prodotti = new HashMap<>();
    }

    public void aggiungiProdotto(Prodotto p) {
        prodotti.put(p.getId(), p);
    }

    public Prodotto getProdotto(String id) {
        return prodotti.get(id);
    }

    public void vendiBeni(String id, int quantita) {
        Prodotto p = prodotti.get(id);
        if (p != null && p.getQuantita() >= quantita) {
            p.riduciQuantita(quantita);
        }
    }

    public void riceviBeni(String id, int quantita) {
        Prodotto p = prodotti.get(id);
        if (p != null) {
            p.aumentaQuantita(quantita);
        }
    }

    // Prodotti ordinati per valore totale decrescente
    public List<Prodotto> prodottiPerValore() {
        return prodotti.values().stream()
            .sorted(Comparator.comparingDouble(Prodotto::getValoreTotale).reversed())
            .collect(Collectors.toList());
    }

    // Prodotti con stock basso
    public List<Prodotto> stockBasso(int soglia) {
        return prodotti.values().stream()
            .filter(p -> p.getQuantita() < soglia)
            .collect(Collectors.toList());
    }

    // Valore totale inventario
    public double valoreComplessivo() {
        return prodotti.values().stream()
            .mapToDouble(Prodotto::getValoreTotale)
            .sum();
    }

    public void stampaInventario() {
        prodotti.values().forEach(System.out::println);
    }
}

// Uso
Inventario inv = new Inventario();
inv.aggiungiProdotto(new Prodotto("P001", "Mela", 50, 2.0));
inv.aggiungiProdotto(new Prodotto("P002", "Banana", 30, 1.5));
inv.aggiungiProdotto(new Prodotto("P003", "Arancia", 20, 2.5));

inv.vendiBeni("P001", 10);
inv.riceviBeni("P002", 15);

inv.stampaInventario();
System.out.println("Valore totale: €" + inv.valoreComplessivo());

System.out.println("\nProdotti per valore:");
inv.prodottiPerValore().forEach(System.out::println);

System.out.println("\nStock basso:");
inv.stockBasso(25).forEach(System.out::println);
```

---

## MODULO 8: Concetti Bridge verso Spring Boot (1 settimana)

### **Settimana 16: Preparazione a Spring Boot**

#### Reflection API

Reflection permette di ispezionare e manipolare classi, metodi, campi a runtime:

```java
// Ottenere Class object
Class<?> classe = Persona.class;
Class<?> classe2 = Class.forName("com.example.Persona");

// Informazioni sulla classe
System.out.println("Nome: " + classe.getName());
System.out.println("Nome semplice: " + classe.getSimpleName());

// Ottenere costruttori
Constructor<?>[] costruttori = classe.getDeclaredConstructors();
for (Constructor<?> c : costruttori) {
    System.out.println(c);
}

// Ottenere campi
Field[] campi = classe.getDeclaredFields();
for (Field f : campi) {
    System.out.println("Campo: " + f.getName() + ", tipo: " + f.getType());
}

// Accedere a campi privati
Field eta = classe.getDeclaredField("eta");
eta.setAccessible(true);  // Necessario per campi privati
Persona p = new Persona("Mario", 30);
System.out.println("Età: " + eta.get(p));

// Ottenere metodi
Method[] metodi = classe.getDeclaredMethods();
for (Method m : metodi) {
    System.out.println(m);
}

// Invocare metodi
Method getNome = classe.getMethod("getNome");
String nome = (String) getNome.invoke(p);

// Creare istanza dinamicamente
Constructor<?> costruttore = classe.getConstructor(String.class, int.class);
Persona p2 = (Persona) costruttore.newInstance("Luigi", 25);
```

#### Annotation

Le annotation forniscono metadati al codice:

```java
// Definire annotation personalizzata
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggabile {
    String valore() default "";
}

// Usare annotation
public class Calcolatrice {
    @Loggabile(valore = "Addizione")
    public int somma(int a, int b) {
        return a + b;
    }

    @Loggabile("Sottrazione")
    public int sottrai(int a, int b) {
        return a - b;
    }
}

// Leggere annotation a runtime
Class<?> calc = Calcolatrice.class;
Method[] metodi = calc.getDeclaredMethods();
for (Method m : metodi) {
    if (m.isAnnotationPresent(Loggabile.class)) {
        Loggabile log = m.getAnnotation(Loggabile.class);
        System.out.println("Metodo: " + m.getName() + ", Log: " + log.valore());
    }
}
```

Annotation comuni built-in:

```java
@Override  // Verifica che sovrascrivi un metodo
@Deprecated  // Segna metodo come obsoleto
@SuppressWarnings  // Ignora avvertimenti compilatore
@FunctionalInterface  // Segna interfaccia come funzionale
```

#### Dependency Injection Manuale

Prima di Spring, implementiamo DI manualmente per capire il concetto:

```java
// Interfaccia per la dipendenza
public interface DatabaseService {
    void salva(String dati);
}

// Implementazione concreta
public class MySQLDatabase implements DatabaseService {
    @Override
    public void salva(String dati) {
        System.out.println("Salvo su MySQL: " + dati);
    }
}

public class PostgreSQLDatabase implements DatabaseService {
    @Override
    public void salva(String dati) {
        System.out.println("Salvo su PostgreSQL: " + dati);
    }
}

// Classe che dipende da DatabaseService
public class UtenteService {
    private DatabaseService db;

    // Constructor Injection (preferito)
    public UtenteService(DatabaseService db) {
        this.db = db;
    }

    public void registraUtente(String nome) {
        System.out.println("Registrando: " + nome);
        db.salva(nome);
    }
}

// Uso senza Spring
DatabaseService mysql = new MySQLDatabase();
UtenteService servizio1 = new UtenteService(mysql);
servizio1.registraUtente("Mario");

DatabaseService postgres = new PostgreSQLDatabase();
UtenteService servizio2 = new UtenteService(postgres);
servizio2.registraUtente("Luigi");
```

#### IoC Container Semplice

Simula quello che fa Spring:

```java
import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<String, Object> beans = new HashMap<>();

    // Registrare un bean (singleton)
    public <T> void register(String nome, T oggetto) {
        beans.put(nome, oggetto);
    }

    // Registrare con factory
    public <T> void register(String nome, Class<T> classe) {
        try {
            T istanza = classe.getDeclaredConstructor().newInstance();
            beans.put(nome, istanza);
        } catch (Exception e) {
            throw new RuntimeException("Errore creazione bean", e);
        }
    }

    // Ottenere un bean
    @SuppressWarnings("unchecked")
    public <T> T getBean(String nome, Class<T> classe) {
        return (T) beans.get(nome);
    }

    public Object getBean(String nome) {
        return beans.get(nome);
    }
}

// Uso
Container container = new Container();
container.register("db", new MySQLDatabase());
container.register("utenteService", UtenteService.class);

DatabaseService db = container.getBean("db", DatabaseService.class);
UtenteService servizio = new UtenteService(db);
servizio.registraUtente("Mario");
```

#### Singleton Pattern

Spring usa singleton per gestire bean:

```java
public class Singleton {
    private static Singleton istanza;
    private String valore;

    private Singleton() {  // Costruttore privato
        this.valore = "Valore singleton";
    }

    public static Singleton getInstance() {
        if (istanza == null) {
            istanza = new Singleton();
        }
        return istanza;
    }

    public String getValore() {
        return valore;
    }
}

// Uso
Singleton s1 = Singleton.getInstance();
Singleton s2 = Singleton.getInstance();
System.out.println(s1 == s2);  // true, stessa istanza

// Thread-safe version
public class SingletonThreadSafe {
    private static SingletonThreadSafe istanza;

    private SingletonThreadSafe() { }

    public synchronized static SingletonThreadSafe getInstance() {
        if (istanza == null) {
            istanza = new SingletonThreadSafe();
        }
        return istanza;
    }
}

// Eager initialization (migliore)
public class SingletonEager {
    private static final SingletonEager ISTANZA = new SingletonEager();

    private SingletonEager() { }

    public static SingletonEager getInstance() {
        return ISTANZA;
    }
}
```

#### Convenzioni Getter e Setter per Spring

Spring usa reflection per accedere a proprietà tramite getter/setter:

```java
// Formato standard per Spring
public class Persona {
    private String nome;
    private int eta;
    private String email;

    // Spring cerca metodi con pattern get<PropertyName>
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// Spring non riconosce
public class PersonaNonValida {
    private String nome;

    public String nome() { return nome; }  // SBAGLIATO
    public String fetchNome() { return nome; }  // SBAGLIATO
}
```

#### Configurazione tramite Properties

```java
// application.properties
public class AppConfig {
    private String nomeProprieta;
    private int portaServer;

    public AppConfig(String nomeProprieta, int portaServer) {
        this.nomeProprieta = nomeProprieta;
        this.portaServer = portaServer;
    }

    public String getNomeProprieta() { return nomeProprieta; }
    public int getPortaServer() { return portaServer; }
}

// Caricamento properties manualmente
import java.io.*;
import java.util.Properties;

public class PropertyLoader {
    public static AppConfig carica() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("config.properties"));

        String nome = props.getProperty("app.name");
        int porta = Integer.parseInt(props.getProperty("server.port"));

        return new AppConfig(nome, porta);
    }
}

// config.properties
/*
app.name=MiaApplicazione
server.port=8080
*/
```

#### Inversion of Control (IoC) Concettuale

```java
// Flusso traditionale (senza IoC)
public class TradizioneMain {
    public static void main(String[] args) {
        // IO crea le dipendenze
        DatabaseService db = new MySQLDatabase();
        UserRepository repo = new UserRepository(db);
        UserService service = new UserService(repo);

        // IO usa il servizio
        service.creaUtente("Mario");
    }
}

// Con IoC (come Spring)
public class IoCSpringingMain {
    public static void main(String[] args) {
        // Container IoC crea le dipendenze
        ApplicationContainer container = new ApplicationContainer();
        container.initialize();

        // IO chiede il servizio
        UserService service = container.getBean("userService", UserService.class);

        // IO usa il servizio
        service.creaUtente("Mario");
    }
}

class ApplicationContainer {
    private Container container;

    public void initialize() {
        container = new Container();

        // Il container gestisce il ciclo di vita
        container.register("database", new MySQLDatabase());
        container.register("userRepository", UserRepository.class);
        container.register("userService", UserService.class);
    }

    public <T> T getBean(String nome, Class<T> classe) {
        return container.getBean(nome, classe);
    }
}
```

#### Custom Annotation per DI

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {
    String valore() default "";
}

public class Iniezione {
    public static <T> void inetta(T obj, Container container)
            throws IllegalAccessException {
        Class<?> classe = obj.getClass();
        Field[] campi = classe.getDeclaredFields();

        for (Field f : campi) {
            if (f.isAnnotationPresent(Inject.class)) {
                Inject inj = f.getAnnotation(Inject.class);
                String nomeBeans = inj.valore().isEmpty() ?
                    f.getName() : inj.valore();

                Object bean = container.getBean(nomeBeans);
                f.setAccessible(true);
                f.set(obj, bean);
            }
        }
    }
}

// Uso
public class UserService {
    @Inject
    private UserRepository repository;

    public void salvaUtente(String nome) {
        repository.salva(nome);
    }
}

// Nel main
UserService service = new UserService();
Iniezione.inetta(service, container);
service.salvaUtente("Mario");
```

#### Esercizio Pratico: Mini Framework DI

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
    String value() default "";
}

public class MiniSpringContainer {
    private Map<String, Object> beans = new HashMap<>();

    public void scanAndRegister(String packageName) throws Exception {
        // Scansiona classi nel package
        // Registra quelle con @Component
    }

    public void autowire(Object obj) throws IllegalAccessException {
        Class<?> classe = obj.getClass();
        Field[] campi = classe.getDeclaredFields();

        for (Field f : campi) {
            if (f.isAnnotationPresent(Autowired.class)) {
                Autowired auto = f.getAnnotation(Autowired.class);
                String nomeBeans = auto.value().isEmpty() ?
                    f.getType().getSimpleName() : auto.value();

                Object bean = beans.get(nomeBeans);
                if (bean != null) {
                    f.setAccessible(true);
                    f.set(obj, bean);
                }
            }
        }
    }

    public <T> T getBean(Class<T> classe) {
        return (T) beans.get(classe.getSimpleName());
    }
}

// Uso
@Component
public class DatabaseService {
    public void salva(String dati) {
        System.out.println("Salvo: " + dati);
    }
}

@Component
public class UserService {
    @Autowired
    private DatabaseService database;

    public void registra(String nome) {
        database.salva(nome);
    }
}
```

---

## MODULO 9: Spring Boot (3 settimane)

### **Settimana 17: Fondamenti di Spring Boot**

#### Cos'è Spring Boot

Spring Boot è un framework che semplifica lo sviluppo di applicazioni Java basate su Spring Framework:

- **Configurazione automatica**: elimina la necessità di XML
- **Embedded server**: non serve Tomcat esterno
- **Dipendenze semplificate**: starters che includono tutto il necessario
- **Production-ready**: metrics, monitoring, health checks
- **Convezioni sopra configurazione**: funziona bene senza configurazione

#### Creazione Progetto Spring Boot

```bash
# Con Maven
mvn archetype:generate \
    -DgroupId=com.example \
    -DartifactId=myapp \
    -DarchetypeArtifactId=maven-archetype-quickstart

# Oppure usare Spring Boot CLI
spring boot new --from=web myapp
```

#### POM.xml Base

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>springboot-app</artifactId>
    <version>1.0.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.5</version>
        <relativePath/>
    </parent>

    <dependencies>
        <!-- Web Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Data JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

#### Applicazione Spring Boot Base

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

L'annotation `@SpringBootApplication` combina:

- `@Configuration`: la classe è sorgente di bean configuration
- `@EnableAutoConfiguration`: abilita auto-configurazione
- `@ComponentScan`: scansiona il package corrente e sottopacchetti

#### REST Controller Base

```java
package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    // GET /api/studenti
    @GetMapping
    public String lista() {
        return "Lista studenti";
    }

    // GET /api/studenti/1
    @GetMapping("/{id}")
    public String ottieni(@PathVariable int id) {
        return "Studente " + id;
    }

    // POST /api/studenti
    @PostMapping
    public String crea(@RequestBody String dati) {
        return "Creato: " + dati;
    }

    // PUT /api/studenti/1
    @PutMapping("/{id}")
    public String aggiorna(@PathVariable int id, @RequestBody String dati) {
        return "Aggiornato " + id + ": " + dati;
    }

    // DELETE /api/studenti/1
    @DeleteMapping("/{id}")
    public String elimina(@PathVariable int id) {
        return "Eliminato " + id;
    }
}
```

#### Entità JPA

```java
package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    private int eta;

    @Column(unique = true)
    private String email;

    // Costruttori
    public Studente() { }

    public Studente(String nome, String cognome, int eta, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", email='" + email + '\'' +
                '}';
    }
}
```

#### Repository Pattern

```java
package com.example.repository;

import com.example.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {

    // Query automatiche da JpaRepository
    // findAll(), findById(), save(), delete(), etc.

    // Custom queries
    List<Studente> findByNome(String nome);

    List<Studente> findByCognome(String cognome);

    Optional<Studente> findByEmail(String email);

    List<Studente> findByEtaGreaterThan(int eta);

    List<Studente> findByNomeContaining(String parte);
}
```

#### Service Layer

```java
package com.example.service;

import com.example.entity.Studente;
import com.example.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository repository;

    // Ricevi repository tramite constructor injection (preferito)
    // public StudenteService(StudenteRepository repository) {
    //     this.repository = repository;
    // }

    public List<Studente> ottieniTutti() {
        return repository.findAll();
    }

    public Optional<Studente> ottieniPerId(Long id) {
        return repository.findById(id);
    }

    public Studente crea(Studente studente) {
        // Logica di business
        if (studente.getEmail() == null || studente.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email richiesta");
        }
        return repository.save(studente);
    }

    public Studente aggiorna(Long id, Studente dati) {
        Optional<Studente> opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("Studente non trovato");
        }

        Studente studente = opt.get();
        studente.setNome(dati.getNome());
        studente.setCognome(dati.getCognome());
        studente.setEta(dati.getEta());
        studente.setEmail(dati.getEmail());

        return repository.save(studente);
    }

    public void elimina(Long id) {
        repository.deleteById(id);
    }

    public List<Studente> cercaPerNome(String nome) {
        return repository.findByNome(nome);
    }

    public Optional<Studente> cercaPerEmail(String email) {
        return repository.findByEmail(email);
    }
}
```

#### REST Controller con Servizio

```java
package com.example.controller;

import com.example.entity.Studente;
import com.example.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    @Autowired
    private StudenteService service;

    // GET /api/studenti
    @GetMapping
    public ResponseEntity<List<Studente>> lista() {
        List<Studente> studenti = service.ottieniTutti();
        return ResponseEntity.ok(studenti);
    }

    // GET /api/studenti/1
    @GetMapping("/{id}")
    public ResponseEntity<Studente> ottieni(@PathVariable Long id) {
        Optional<Studente> studente = service.ottieniPerId(id);
        return studente
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET /api/studenti/cerca?nome=Mario
    @GetMapping("/cerca")
    public ResponseEntity<List<Studente>> cercaNome(
            @RequestParam String nome) {
        List<Studente> studenti = service.cercaPerNome(nome);
        return ResponseEntity.ok(studenti);
    }

    // POST /api/studenti
    @PostMapping
    public ResponseEntity<Studente> crea(@RequestBody Studente studente) {
        try {
            Studente creato = service.crea(studente);
            return ResponseEntity.status(HttpStatus.CREATED).body(creato);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // PUT /api/studenti/1
    @PutMapping("/{id}")
    public ResponseEntity<Studente> aggiorna(
            @PathVariable Long id,
            @RequestBody Studente dati) {
        try {
            Studente aggiornato = service.aggiorna(id, dati);
            return ResponseEntity.ok(aggiornato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/studenti/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimina(@PathVariable Long id) {
        service.elimina(id);
        return ResponseEntity.noContent().build();
    }
}
```

#### application.properties

```properties
# Server
server.port=8080
server.servlet.context-path=/

# Database H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Logging
logging.level.root=INFO
logging.level.com.example=DEBUG
```

---

### **Settimana 18: Aspetti Avanzati di Spring Boot**

#### Exception Handling Globale

```java
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

public class ErrorResponse {
    private String messaggio;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ErrorResponse(String messaggio, HttpStatus status) {
        this.messaggio = messaggio;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getMessaggio() { return messaggio; }
    public HttpStatus getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(
            IllegalArgumentException e) {
        ErrorResponse errore = new ErrorResponse(
            e.getMessage(),
            HttpStatus.BAD_REQUEST
        );
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errore);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntime(
            RuntimeException e) {
        ErrorResponse errore = new ErrorResponse(
            e.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errore);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception e) {
        ErrorResponse errore = new ErrorResponse(
            "Errore interno del server",
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errore);
    }
}
```

#### Validazione Input

```java
package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome è obbligatorio")
    @Size(min = 2, max = 50, message = "Nome deve essere tra 2 e 50 caratteri")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Cognome è obbligatorio")
    @Column(nullable = false)
    private String cognome;

    @Min(value = 18, message = "Età minima 18")
    @Max(value = 100, message = "Età massima 100")
    private int eta;

    @Email(message = "Email non valida")
    @NotBlank(message = "Email è obbligatoria")
    @Column(unique = true)
    private String email;

    // Costruttori, getters, setters...
}

// Nel controller
@PostMapping
public ResponseEntity<Studente> crea(
        @Valid @RequestBody Studente studente,
        BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
        String errori = bindingResult.getAllErrors()
            .stream()
            .map(e -> e.getDefaultMessage())
            .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().build();
    }

    Studente creato = service.crea(studente);
    return ResponseEntity.status(HttpStatus.CREATED).body(creato);
}
```

#### Logging

```java
package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudenteService {

    private static final Logger logger = LoggerFactory.getLogger(StudenteService.class);

    public Studente crea(Studente studente) {
        logger.info("Creando nuovo studente con email: {}", studente.getEmail());

        try {
            Studente creato = repository.save(studente);
            logger.info("Studente creato con ID: {}", creato.getId());
            return creato;
        } catch (Exception e) {
            logger.error("Errore nella creazione studente", e);
            throw e;
        }
    }
}
```

#### Gestione dei Profili

```properties
# application.properties (default)
spring.profiles.active=dev

# application-dev.properties
server.port=8080
spring.jpa.show-sql=true
logging.level.com.example=DEBUG

# application-prod.properties
server.port=9000
spring.jpa.show-sql=false
logging.level.com.example=INFO
```

```bash
# Eseguire con profilo
java -jar app.jar --spring.profiles.active=prod
```

#### DTO (Data Transfer Object)

```java
package com.example.dto;

public class StudenteDTO {
    private Long id;
    private String nome;
    private String cognome;
    private int eta;
    private String email;

    // Costruttori
    public StudenteDTO() { }

    public StudenteDTO(Long id, String nome, String cognome,
                       int eta, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// Mapper
package com.example.mapper;

import com.example.entity.Studente;
import com.example.dto.StudenteDTO;
import org.springframework.stereotype.Component;

@Component
public class StudenteMapper {

    public StudenteDTO toDTO(Studente studente) {
        return new StudenteDTO(
            studente.getId(),
            studente.getNome(),
            studente.getCognome(),
            studente.getEta(),
            studente.getEmail()
        );
    }

    public Studente toEntity(StudenteDTO dto) {
        Studente studente = new Studente();
        studente.setNome(dto.getNome());
        studente.setCognome(dto.getCognome());
        studente.setEta(dto.getEta());
        studente.setEmail(dto.getEmail());
        return studente;
    }
}

// Nel controller
@GetMapping("/{id}")
public ResponseEntity<StudenteDTO> ottieni(@PathVariable Long id) {
    Optional<Studente> studente = service.ottieniPerId(id);
    return studente
        .map(s -> ResponseEntity.ok(mapper.toDTO(s)))
        .orElseGet(() -> ResponseEntity.notFound().build());
}
```

#### Transazioni

```java
package com.example.service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class StudenteService {

    @Transactional(readOnly = true)
    public List<Studente> ottieniTutti() {
        return repository.findAll();
    }

    @Transactional
    public Studente crea(Studente studente) {
        // Tutta l'operazione è transazionale
        // Se fallisce, si fa rollback automatico
        return repository.save(studente);
    }

    @Transactional
    public void elaboraLotti(List<Studente> studenti) {
        for (Studente s : studenti) {
            repository.save(s);
        }
        // Se uno fallisce, rollback di tutti
    }
}
```

#### Caching

```java
package com.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
}

// Nel service
package com.example.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

@Service
public class StudenteService {

    @Cacheable(value = "studenti", key = "#id")
    public Optional<Studente> ottieniPerId(Long id) {
        // Risultato cachato per 10 minuti (configurabile)
        return repository.findById(id);
    }

    @CacheEvict(value = "studenti", key = "#id")
    public void elimina(Long id) {
        repository.deleteById(id);
    }

    @CacheEvict(value = "studenti", allEntries = true)
    public Studente crea(Studente studente) {
        return repository.save(studente);
    }
}
```

---

### **Settimana 19: Relazioni e Progetto Finale**

#### Relazioni One-to-Many

```java
// Genitore
@Entity
@Table(name = "corsi")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private List<Esame> esami = new ArrayList<>();

    public void aggiungiEsame(Esame esame) {
        esame.setCorso(this);
        esami.add(esame);
    }

    // Getters e setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Esame> getEsami() { return esami; }
}

// Figlio
@Entity
@Table(name = "esami")
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int voto;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    // Getters e setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }
    public Corso getCorso() { return corso; }
    public void setCorso(Corso corso) { this.corso = corso; }
}
```

#### Relazioni Many-to-Many

```java
@Entity
@Table(name = "studenti_corsi")
@Getter
@Setter
public class StudenteCorso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    private LocalDate dataIscrizione;
    private String stato;
}

// Nei controller
@PostMapping("/{studenteId}/corsi/{corsoId}")
public ResponseEntity<StudenteCorso> iscriviAlCorso(
        @PathVariable Long studenteId,
        @PathVariable Long corsoId) {
    StudenteCorso iscrizione = service.iscrivi(studenteId, corsoId);
    return ResponseEntity.status(HttpStatus.CREATED).body(iscrizione);
}
```

#### Progetto Finale: Piattaforma E-Learning Completa

**Struttura del Progetto:**

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── entity/
│   │   │   ├── Studente.java
│   │   │   ├── Insegnante.java
│   │   │   ├── Corso.java
│   │   │   ├── Lezione.java
│   │   │   ├── Esame.java
│   │   │   └── Valutazione.java
│   │   ├── repository/
│   │   │   ├── StudenteRepository.java
│   │   │   ├── CorsoRepository.java
│   │   │   └── EsameRepository.java
│   │   ├── service/
│   │   │   ├── StudenteService.java
│   │   │   ├── CorsoService.java
│   │   │   └── EsameService.java
│   │   ├── controller/
│   │   │   ├── StudenteController.java
│   │   │   ├── CorsoController.java
│   │   │   └── EsameController.java
│   │   ├── dto/
│   │   │   ├── StudenteDTO.java
│   │   │   ├── CorsoDTO.java
│   │   │   └── EsameDTO.java
│   │   ├── mapper/
│   │   │   ├── StudenteMapper.java
│   │   │   └── CorsoMapper.java
│   │   ├── exception/
│   │   │   ├── ErrorResponse.java
│   │   │   └── GlobalExceptionHandler.java
│   │   ├── config/
│   │   │   └── AppConfig.java
│   │   └── Application.java
│   └── resources/
│       ├── application.properties
│       ├── application-dev.properties
│       └── application-prod.properties
└── test/
    └── java/com/example/
        ├── StudenteServiceTest.java
        └── CorsoControllerTest.java
```

**Entità Principali:**

```java
// Studente
@Entity
@Table(name = "studenti")
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    private LocalDateTime dataIscrizione;

    @OneToMany(mappedBy = "studente", cascade = CascadeType.ALL)
    private List<Valutazione> valutazioni = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "studente_corso",
        joinColumns = @JoinColumn(name = "studente_id"),
        inverseJoinColumns = @JoinColumn(name = "corso_id")
    )
    private List<Corso> corsi = new ArrayList<>();

    // Getters, setters, toString
}

// Corso
@Entity
@Table(name = "corsi")
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "insegnante_id")
    private Insegnante insegnante;

    private LocalDateTime dataCreazione;

    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private List<Lezione> lezioni = new ArrayList<>();

    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
    private List<Esame> esami = new ArrayList<>();

    @ManyToMany(mappedBy = "corsi")
    private List<Studente> studenti = new ArrayList<>();

    // Getters, setters, toString
}

// Esame
@Entity
@Table(name = "esami")
public class Esame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titolo;

    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    private LocalDateTime dataEsame;

    @OneToMany(mappedBy = "esame", cascade = CascadeType.ALL)
    private List<Valutazione> valutazioni = new ArrayList<>();

    // Getters, setters, toString
}

// Valutazione
@Entity
@Table(name = "valutazioni")
public class Valutazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "esame_id")
    private Esame esame;

    @Min(0)
    @Max(30)
    private int voto;

    private LocalDateTime dataValutazione;

    private String note;

    // Getters, setters, toString
}
```

**Service Layer Completo:**

```java
@Service
@Transactional
public class CorsoService {

    private final CorsoRepository repo;
    private final StudenteRepository studenteRepo;
    private final CorsoMapper mapper;

    @Autowired
    public CorsoService(CorsoRepository repo,
                       StudenteRepository studenteRepo,
                       CorsoMapper mapper) {
        this.repo = repo;
        this.studenteRepo = studenteRepo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<CorsoDTO> ottieniTutti() {
        return repo.findAll().stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<CorsoDTO> ottieniPerId(Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public CorsoDTO crea(CorsoDTO dto) {
        Corso corso = mapper.toEntity(dto);
        corso.setDataCreazione(LocalDateTime.now());
        Corso salvato = repo.save(corso);
        return mapper.toDTO(salvato);
    }

    public void iscriviStudente(Long corsoId, Long studenteId) {
        Corso corso = repo.findById(corsoId)
            .orElseThrow(() -> new RuntimeException("Corso non trovato"));
        Studente studente = studenteRepo.findById(studenteId)
            .orElseThrow(() -> new RuntimeException("Studente non trovato"));

        if (!corso.getStudenti().contains(studente)) {
            corso.getStudenti().add(studente);
            studente.getCorsi().add(corso);
            repo.save(corso);
        }
    }

    public List<CorsoDTO> corsidiStudente(Long studenteId) {
        Studente studente = studenteRepo.findById(studenteId)
            .orElseThrow(() -> new RuntimeException("Studente non trovato"));
        return studente.getCorsi().stream()
            .map(mapper::toDTO)
            .collect(Collectors.toList());
    }
}
```

**Controller REST Completo:**

```java
@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    @Autowired
    private CorsoService service;

    @GetMapping
    public ResponseEntity<List<CorsoDTO>> lista() {
        return ResponseEntity.ok(service.ottieniTutti());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorsoDTO> ottieni(@PathVariable Long id) {
        Optional<CorsoDTO> corso = service.ottieniPerId(id);
        return corso.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CorsoDTO> crea(@Valid @RequestBody CorsoDTO dto) {
        CorsoDTO creato = service.crea(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PostMapping("/{corsoId}/studenti/{studenteId}")
    public ResponseEntity<Void> iscriviStudente(
            @PathVariable Long corsoId,
            @PathVariable Long studenteId) {
        service.iscriviStudente(corsoId, studenteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/studenti/{studenteId}")
    public ResponseEntity<List<CorsoDTO>> corsidiStudente(
            @PathVariable Long studenteId) {
        return ResponseEntity.ok(service.corsidiStudente(studenteId));
    }
}
```

**Testing:**

```java
@SpringBootTest
public class CorsoServiceTest {

    @Autowired
    private CorsoService service;

    @Autowired
    private CorsoRepository repository;

    @Test
    void testCreaCorso() {
        CorsoDTO dto = new CorsoDTO();
        dto.setNome("Java Avanzato");
        dto.setDescrizione("Corso su Spring Boot");

        CorsoDTO creato = service.crea(dto);

        assertNotNull(creato.getId());
        assertEquals("Java Avanzato", creato.getNome());
    }

    @Test
    void testOttieniTutti() {
        List<CorsoDTO> corsi = service.ottieniTutti();
        assertNotNull(corsi);
        assertTrue(corsi.size() >= 0);
    }
}

@SpringBootTest
@AutoConfigureMockMvc
public class CorsoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/corsi"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testCreaCorso() throws Exception {
        String json = "{\"nome\":\"Java\",\"descrizione\":\"Corso Java\"}";

        mockMvc.perform(post("/api/corsi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated());
    }
}
```
