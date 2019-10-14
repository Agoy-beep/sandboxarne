package game_of_life;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void givenALivingCell_whenAssignedASpecificLocation_thenAppearOnGameBoard() {
        //GIVEN
        Game game = new Game();
        //WHEN
        game.putALivingCellAtCoordinate(1, 3);
        //THEN
        Assertions.assertEquals("[X]", game.getGameBoard().getBoard()[1][3]);
        Assertions.assertEquals("[ ]", game.getGameBoard().getBoard()[1][2]);
    }

    @Test
    void whenGivenANumberOfLivingCells_assertThatACellThatWillBecomeLivingIsDead() {
        //GIVEN
        Game game = new Game();
        //WHEN
        game.putALivingCellAtCoordinate(2, 3);
        game.putALivingCellAtCoordinate(0,2);
        game.putALivingCellAtCoordinate(0, 4);
        //THEN
        Assertions.assertEquals("[ ]", game.getGameBoard().getBoard()[1][3]);
    }
}