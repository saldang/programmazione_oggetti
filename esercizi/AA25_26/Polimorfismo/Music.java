class Instrument {
    public void play() {
        System.out.println("Play Instrument");
    }
}

class Wind extends Instrument { // Redefine interface method:
    public void play() {
        System.out.println("Wind.play() ");
    }
}

class Stringed extends Instrument {
    public void play() {
        System.out.println("Stringed.play() ");
    }
}

class Brass extends Instrument {
    public void play() {
        System.out.println("Brass.play() ");
    }
}

public class Music {
    public static void tune(Instrument i) {
        i.play();
    }

    // Polimorf.
    public static void main(String[] args) {
        Wind flute = new Wind();
        //
        Stringed violin = new Stringed();
        Brass bas = new Brass();
        tune(flute);

        tune(violin);
        tune(bas);
    }
}
