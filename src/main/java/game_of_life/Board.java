package game_of_life;

public class Board {

    private static final int AMOUNT_OF_ROWS = 8;
    private static final int AMOUNT_OF_COLUMNS = 8;
    private String[][] board;
    private final String emptyTile = "[ ]";
    private final char markOfLivingCell = 'X';

    public Board() {
        this.board = new String[AMOUNT_OF_ROWS][AMOUNT_OF_COLUMNS];
    }

    public void drawBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){

            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++) {
                System.out.print(board[row][column] = emptyTile);
            }
            System.out.println();
        }
    }

    public void drawNextGen(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){

            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++) {
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    public String[][] getBoard() {
        return board;
    }
}
