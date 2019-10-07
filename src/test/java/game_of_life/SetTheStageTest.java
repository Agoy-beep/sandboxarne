package game_of_life;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetTheStageTest {

    @Test
    void givenALivingCell_whenAssignedASpecificLocation_thenAppearOnGameBoard() {
        //GIVEN
        SetTheStage game = new SetTheStage();
        //WHEN
        game.putALivingCellAtCoordinate(1, 3);
        //THEN
        Assertions.assertEquals("[X]", game.getGameBoard().getBoard()[1][3]);
        Assertions.assertEquals("[ ]", game.getGameBoard().getBoard()[1][2]);
    }

    @Test
    void whenGivenANumberOfLivingCells_assertThatACellThatWillBecomeLivingIsDead() {
        //GIVEN
        SetTheStage game = new SetTheStage();
        //WHEN
        game.putALivingCellAtCoordinate(2, 3);
        game.putALivingCellAtCoordinate(0,2);
        game.putALivingCellAtCoordinate(0, 4);
        //THEN
        Assertions.assertEquals("[ ]", game.getGameBoard().getBoard()[1][3]);
    }
}