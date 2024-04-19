public class ChessGame {


    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.printBoard();
    }
}

public class ChessBoard{

    int[][] board = new int[8][8];

    public ChessBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = 0;
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}
