package game_of_life;

public class Board {

    public static final int AMOUNT_OF_ROWS = 8;
    public static final int AMOUNT_OF_COLUMNS = 8;
    private String[][] board;
    private final String deadCellTile = "[ ]";
    private final String livingCellTile = "[X]";
    private int livingNeighbours = 0;
    private boolean cellIsAlive;
    private String[][] nextLifeCycleBoard;

    public String[][] getNextLifeCycleBoard() {
        return nextLifeCycleBoard;
    }

    public Board() {
        this.board = new String[AMOUNT_OF_ROWS][AMOUNT_OF_COLUMNS];
        this.nextLifeCycleBoard = new String[AMOUNT_OF_ROWS][AMOUNT_OF_COLUMNS];
        this.setInitialBoard();
    }

    public void setInitialBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){
            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++) {
                board[row][column] = deadCellTile;
            }
        }
    }

    public void drawBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){

            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++) {
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    public void drawNextLifeCycleBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){

            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++) {
                System.out.print(nextLifeCycleBoard[row][column]);
            }
            System.out.println();
        }
        board = nextLifeCycleBoard;
    }


    public String[][] getBoard() {
        return board;
    }
    public String getDeadCellTile() {
        return deadCellTile;
    }

    public String getLivingCellTile() {
        return livingCellTile;
    }
    public void calculateNewBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){
            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++){
                this.calculateLivingNeighbours(board, row, column);
            }
        }
    }
    public void calculateLivingNeighbours(String[][] board, int row, int column) {
        livingNeighbours = 0;
        if(row != 0 && row <= 6 && column != 0 && column <= 6){
            for(int i = row - 1; i <= row + 1; i++){
                for(int j = column - 1; j <= column + 1; j++){
                    if(i == row && j == column){
                        continue;
                    }
                    else{
                        if(board[i][j].equals(getLivingCellTile())){
                            livingNeighbours++;
                        }
                    }
                }
            }
        }

        this.checkNextLifeState(livingNeighbours);
        if(cellIsAlive){
            nextLifeCycleBoard[row][column] = this.getLivingCellTile();
        }
        else{
            nextLifeCycleBoard[row][column] = this.getDeadCellTile();
        }
    }

    public void checkNextLifeState(int livingNeighboursCount) {
        if(cellIsAlive){
            if(livingNeighboursCount < 2 || livingNeighboursCount > 3){
                cellIsAlive = false;
            }
        }
        else{
            if(livingNeighboursCount == 3){
                cellIsAlive = true;
            }
        }
    }
}
