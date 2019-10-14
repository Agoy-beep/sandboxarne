package game_of_life;

import java.util.Scanner;

public class SetTheStage {

    private final Board gameBoard;
    public static int COUNT = 0;
    private final Scanner playerInput = new Scanner(System.in);

    public SetTheStage() {
        this.gameBoard = new Board();
        runMainMenu();
    }

    public void aksUserToSelectLivingCells(){
        int inputRow = getUserInputRow();
        int inputColumn = getUserInputColumn();

        this.putALivingCellAtCoordinate(inputRow, inputColumn);
        this.validateIfUserWantsToAddAnotherLivingCell();
    }

    private int getUserInputColumn() {
        System.out.println("Please specify a column for a living cell");
        int inputColumn = Integer.parseInt(playerInput.nextLine());
        try{
            if(inputColumn > gameBoard.AMOUNT_OF_COLUMNS){
                throw new IllegalArgumentException();
            }
            return inputColumn;
        } catch (NumberFormatException numex){
            System.err.println("That wasn't right.");
        }
        return this.getUserInputColumn();
    }

    private int getUserInputRow() {
        System.out.println("Please specify a row for a living cell");

        try{
            int inputRow = Integer.parseInt(playerInput.nextLine());
            if(inputRow > gameBoard.AMOUNT_OF_ROWS){
                throw new IllegalArgumentException();
            }
            return inputRow;
        } catch (NumberFormatException numex){
            System.err.println("That wasn't right!");
        }
        return this.getUserInputRow();
    }

    public void putALivingCellAtCoordinate(int row, int column){
        gameBoard.getBoard()[row][column] = gameBoard.getLivingCellTile();
        gameBoard.drawBoard();
        System.out.println();
    }

    public void putALivingCellAtCoordinateWithoutPrintingBoard(int row, int column){
        gameBoard.getBoard()[row][column] = gameBoard.getLivingCellTile();
    }

    public void validateIfUserWantsToAddAnotherLivingCell(){
        System.out.println("Would you like to add another living cell? Yes/No: ");
        String playerAnswer = playerInput.nextLine();
        if(playerAnswer.toLowerCase().contains("y")){
            this.aksUserToSelectLivingCells();
        } else{
            this.getGameBoard().drawBoard();
        }
    }

    public void askUserToPressEnterToPrintNewLifeCycle(){
        System.out.println("Generation: " + COUNT +
                "\nPress enter to see the next lifecycle. \ntype 'Q' to quit. \n");
        String playerAnswer = playerInput.nextLine();
        if(!playerAnswer.equals("Q")){
            COUNT++;
            this.getGameBoard().calculateNewBoard();
            this.getGameBoard().drawNextLifeCycleBoard();
            this.askUserToPressEnterToPrintNewLifeCycle();
        } else{
            System.out.println("Thanks for playing Game Of Life! You've made " + COUNT + " generations.");
        }
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void runMainMenu(){
        System.out.println(" ---------------------------\n|    <--[GAME OF LIFE]-->    |\n ---------------------------");
        System.out.println();
        System.out.println("CHOOSE: \n1)Simulate Game Of Life \n2)Play Game Of Life \n3)Leave");
        String playerChoice = playerInput.nextLine();
        int playerChoiceToInt = Integer.parseInt(playerChoice);
        switch(playerChoiceToInt){
            case 1:
                COUNT = 0;
                this.runSimulation();
                this.runMainMenu();
                break;
            case 2:
                COUNT = 0;
                this.runPlayerGameOfLife();
                this.runMainMenu();
                break;
            case 3:
                System.out.println("Byebye!");
                break;
        }
    }

    private void runSimulation() {

        this.getGameBoard().setInitialBoard();
        this.putALivingCellAtCoordinateWithoutPrintingBoard(1, 3);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(2, 5);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(3, 3);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(2, 2);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(5, 7);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(6, 1);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(6, 2);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(6, 5);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(3, 5);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(4, 5);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(2, 0);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(3, 1);
        this.putALivingCellAtCoordinateWithoutPrintingBoard(6, 1);

        this.getGameBoard().calculateNewBoard();
        this.getGameBoard().drawNextLifeCycleBoard();
        this.askUserToPressEnterToPrintNewLifeCycle();
    }

    public void runPlayerGameOfLife(){
        this.getGameBoard().setInitialBoard();
        this.aksUserToSelectLivingCells();
        this.askUserToPressEnterToPrintNewLifeCycle();
    }
}
