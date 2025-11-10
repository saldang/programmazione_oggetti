class Game {
    Game(int i) {
        System.out.println("Game constructor " + i);
    }

    Game(float j) {
        System.out.println("Game constructor " + j);
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor " + i);
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor ");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
