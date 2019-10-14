package game_of_life;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void givenASpecificCell_whenChecked_assertThatTheCellWillBecomeAlive() {
        //GIVEN
        Game game = new Game();
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
        Assertions.assertEquals("[ ]", game.getGameBoard().getNextLifeCycleBoard()[0][2]);
        Assertions.assertEquals("[ ]", game.getGameBoard().getNextLifeCycleBoard()[2][3]);
    }
    @Test
    void givenASpecificCell_whenChecked_assertThatTheCellWillStayDead() {
        //GIVEN
        Game game = new Game();
        //WHEN
        game.putALivingCellAtCoordinate(2, 3);
        game.putALivingCellAtCoordinate(0,2);
        game.putALivingCellAtCoordinate(0, 4);
        //game.getGameBoard().calculateLivingNeighbours(game.getGameBoard().getBoard(), 1, 4);
        game.getGameBoard().calculateNewBoard();
        System.out.println();
        game.getGameBoard().drawNextLifeCycleBoard();
        //THEN
        Assertions.assertEquals("[ ]", game.getGameBoard().getNextLifeCycleBoard()[1][4]);

    }
}