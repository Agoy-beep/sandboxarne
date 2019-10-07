package game_of_life;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void givenALivingCell_WhenSurroundedByLessThan2Cells_TheCellDies() {
        //GIVEN
        Cell testCell = new Cell(false);


        //WHEN
        testCell.checkNextLifeState();
        //THEN

        Assertions.assertEquals(true, testCell.isAlive());
    }
}