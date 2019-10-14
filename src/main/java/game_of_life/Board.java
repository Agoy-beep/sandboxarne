package game_of_life;

public class Board {

    public static final int AMOUNT_OF_ROWS = 8;
    public static final int AMOUNT_OF_COLUMNS = 8;
    private String[][] board;
    private String[][] nextLifeCycleBoard;
    private final String deadCellTile = "[ ]";
    private final String livingCellTile = "[X]";
    private boolean cellIsAlive;

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

    public void calculateNewBoard(){
        for(int row = 0; row < AMOUNT_OF_ROWS; row++){
            for(int column = 0; column < AMOUNT_OF_COLUMNS; column++){
                this.calculateLivingNeighbours(board, row, column);
            }
        }
    }

    public void calculateLivingNeighbours(String[][] board, int row, int column) {
        int livingNeighbours = 0;

        if(board[row][column].equals("[X]")){
            cellIsAlive = true;
        }
        else{
            cellIsAlive = false;
        }

        int startRow = findStartRow(row);
        int endRow = findEndRow(row);
        int startColumn = findStartColumn(column);
        int endColumn = findEndColumn(column);

        for(int i = startRow; i <= endRow; i++){
            for(int j = startColumn; j <= endColumn ; j++){
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

        this.checkNextLifeState(livingNeighbours);
        if(cellIsAlive){
            nextLifeCycleBoard[row][column] = this.getLivingCellTile();
        }
        else{
            nextLifeCycleBoard[row][column] = this.getDeadCellTile();
        }
    }

    private int findEndColumn(int column) {
        if(column + 1 >= 8){
            return 7;
        }
        else{
            return column + 1;
        }
    }

    private int findStartColumn(int column) {
        if(column - 1 < 0){
            return column;
        }
        else{
            return column - 1;
        }
    }

    private int findEndRow(int row) {
        if(row + 1 >= 8){
            return 7;
        }
        else{
            return row + 1;
        }
    }

    private int findStartRow(int row) {
        if(row == 0){
            return row;
        }
        else{
            return row - 1;
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

    public String[][] getBoard() {
        return board;
    }

    public String getDeadCellTile() {
        return deadCellTile;
    }

    public String[][] getNextLifeCycleBoard() {
        return nextLifeCycleBoard;
    }

    public String getLivingCellTile() {
        return livingCellTile;
    }
}
