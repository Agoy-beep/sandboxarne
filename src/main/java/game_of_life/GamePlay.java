package game_of_life;

import java.util.Scanner;

public class GamePlay {

    private Board gameBoard = new Board();
    private final Scanner playerInput = new Scanner(System.in);


    public void selectLivingCells(){
        System.out.println("Please specify a row for a living cell");
        String inputRow = playerInput.nextLine();
        System.out.println("Please specify a column for a living cell");
        String inputColumn = playerInput.nextLine();
    }

    public void putALivingCellAtCoordinate(int row, int column){
        gameBoard.getBoard()[row][column] = "[X]";
        gameBoard.drawNextGen();
    }
}
