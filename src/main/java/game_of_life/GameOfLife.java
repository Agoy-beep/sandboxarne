package game_of_life;

public class GameOfLife {

    public static void main(String[] args) {
        Board emptyBoard = new Board();

        emptyBoard.drawBoard();
        emptyBoard.drawNextGen();
    }
}
