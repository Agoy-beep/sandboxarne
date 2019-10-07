package game_of_life;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void givenASpecificCell_whenChecked_assertThatTheCellWillBecomeAlive() {
        //GIVEN
        SetTheStage game = new SetTheStage();
        //WHEN
        game.putALivingCellAtCoordinate(2, 3);
        game.putALivingCellAtCoordinate(0,2);
        game.putALivingCellAtCoordinate(0, 4);
        //game.getGameBoard().calculateLivingNeighbours(game.getGameBoard().getBoard(), 1, 3);
        game.getGameBoard().calculateNewBoard();
        System.out.println();
        game.getGameBoard().drawNextLifeCycleBoard();


        //THEN
        Assertions.assertEquals("[X]", game.getGameBoard().getNextLifeCycleBoard()[1][3]);
    }
}