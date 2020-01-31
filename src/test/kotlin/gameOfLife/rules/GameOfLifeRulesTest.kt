package gameOfLife.rules

import com.google.common.truth.Truth.assertThat
import gameOfLife.rules.CellStatus.*
import org.junit.Test

class GameOfLifeRulesTest {
    @Test
    fun `given a live cell with two live neighbors, should return as live for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = LIVE
        val neighbors = intArrayOf(0,1,1,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a live cell with three live neighbors, should return as live for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = LIVE
        val neighbors = intArrayOf(0,1,1,0,0,0,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a live cell  with 1 live neighbor, should return as dead for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,0,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a live cell with 0 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,0,0,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a live cell with 4 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,1,0,0,1,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a cell with 5 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = LIVE
        val expectedStatus = DEAD
        val neighbors = intArrayOf(1,1,1,1,0,0,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 0 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,0,0,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 1 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,0,1,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell, with 2 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,1,0,0,0,0,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 3 live neighbors, should return as live for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = LIVE
        val neighbors = intArrayOf(0,1,1,0,0,0,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 4 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,1,0,0,1,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 5 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,1,0,1,1,1,0)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 6 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(0,1,1,0,1,1,1,1)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 7 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(1,1,1,0,1,1,1,1)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }

    @Test
    fun `given a dead cell with 8 live neighbors, should return as dead for next iteration`() {
        val currentCellStatus = DEAD
        val expectedStatus = DEAD
        val neighbors = intArrayOf(1,1,1,1,1,1,1,1)

        val actualStatus = checkIsAlive(currentCellStatus,neighbors)

        assertThat(actualStatus).isEqualTo(expectedStatus)
    }
}