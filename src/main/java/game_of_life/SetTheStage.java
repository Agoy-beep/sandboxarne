package game_of_life;

import java.util.Scanner;

public class SetTheStage {

    private Board gameBoard;
    private final Scanner playerInput = new Scanner(System.in);

    public SetTheStage() {
        this.gameBoard = new Board();
    }

    public void selectLivingCells(){
        System.out.println("Please specify a row for a living cell");
        int inputRow = Integer.parseInt(playerInput.nextLine());
        if(inputRow > gameBoard.AMOUNT_OF_ROWS){
           throw new IllegalArgumentException();
        }
        System.out.println("Please specify a column for a living cell");
        int inputColumn = Integer.parseInt(playerInput.nextLine());
        if(inputColumn > gameBoard.AMOUNT_OF_COLUMNS){
            throw new IllegalArgumentException();
        }

        this.putALivingCellAtCoordinate(inputRow, inputColumn);
    }

    public void putALivingCellAtCoordinate(int row, int column){

        gameBoard.getBoard()[row][column] = gameBoard.getLivingCellTile();
        gameBoard.drawBoard();
        System.out.println();
    }

    public Board getGameBoard() {
        return gameBoard;
    }
}
