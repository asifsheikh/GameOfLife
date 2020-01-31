package gameOfLife.rules

import com.google.common.truth.Truth.assertThat
import gameOfLife.rules.CellStatus.*
import org.junit.Test

class GameOfLifeRulesTest {
    @Test
    fun `given a cell with two live neighbors, should return as live for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = LIVE
        val neighbors = arrayOf(0,1,1,0,0,0,0,0)
        val rules = GameOfLifeRule()

        val actualStatus = rules.checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a cell with three live neighbors, should return as live for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = LIVE
        val neighbors = arrayOf(0,1,1,0,0,0,1,0)
        val rules = GameOfLifeRule()

        val actualStatus = rules.checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }
}