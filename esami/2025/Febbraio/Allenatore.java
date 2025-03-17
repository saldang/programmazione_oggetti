import java.util.List;
import java.util.ArrayList;

public class Allenatore {
    private String nome;
    private Mazzo mazzo;
    private List<Carta> mano;
    private CartaPokemon pokemonAttivo;

    public Allenatore(String nome) {
        this.nome = nome;
        this.mazzo = new Mazzo();
        this.mano = new ArrayList<>();
    }

    public void pescaCarte(int numeroCarte) {
        for (int i = 0; i < numeroCarte; i++) {
            Carta carta = mazzo.pescaCarta();
            if (carta != null) {
                mano.add(carta);
            }
        }
    }

    public void giocaCarta(Carta carta) {
        if (mano.contains(carta)) {
            mano.remove(carta);
            if (carta instanceof CartaPokemon) {
                if (pokemonAttivo != null) {
                    System.out.println("Hai già un Pokémon attivo, devi prima ritirare quello attuale.");
                } else {
                    pokemonAttivo = (CartaPokemon) carta;
                    System.out.println("Hai giocato " + pokemonAttivo.getNome() + " come Pokémon attivo.");
                }
            } else {
                System.out.println("Non puoi giocare questa carta.");
            }
        } else {
            System.out.println("La carta non è nella tua mano.");
        }
    }

    public void ritiraPokemon() {
        if (pokemonAttivo != null) {
            System.out.println("Hai ritirato " + pokemonAttivo.getNome() + ".");
            pokemonAttivo = null;
        } else {
            System.out.println("Non hai un Pokémon attivo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public CartaPokemon getPokemonAttivo() {
        return pokemonAttivo;
    }

    public void setPokemonAttivo(CartaPokemon pokemonAttivo) {
        this.pokemonAttivo = pokemonAttivo;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

    public void prelevaCartaPremio(CartaPokemon difensore) {
        difensore.setPuntiVita(difensore.getPuntiVitaIniziali());
        mano.add(difensore);
    }

    public boolean haCartePremio() {
        System.out.println(mano.stream().anyMatch(CartaPokemon.class::isInstance));
        return mano.stream().anyMatch(CartaPokemon.class::isInstance);
    }

    public void stampaMano() {
        System.out.println("Mano di " + nome + ":");
        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i + 1) + ". " + mano.get(i).getNome());
        }
    }
}
