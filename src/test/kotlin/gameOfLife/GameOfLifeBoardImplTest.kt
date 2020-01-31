package gameOfLife

import com.google.common.truth.Truth.assertThat
import gameOfLife.board.GameOfLifeBoardImpl
import gameOfLife.rules.CellStatus.*
import org.junit.Before
import org.junit.Test

class GameOfLifeBoardImplTest {

    private lateinit var board: GameOfLifeBoardImpl

    @Before
    fun setUp() {
        board = GameOfLifeBoardImpl(6)
        board.initialize()
    }

    @Test
    fun `should initialize the board with default configuration`() {
        val numberOfRows = board.playingBoard.size
        val numberOfCols = board.playingBoard[0].size

        assertThat(numberOfRows).isEqualTo(6)
        assertThat(numberOfCols).isEqualTo(6)
    }

    @Test
    fun `should get the correct cell status for given row and column number`() {
        val expectedCellStatus = LIVE
        val rowNumber = 3
        val columnNumber = 3

        val actualCellStatus = board.getCellStatus(rowNumber, columnNumber)

        assertThat(actualCellStatus).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should get the correct cell status for row and column number`() {
        val expectedCellStatus = LIVE
        val rowNumber = 0
        val columnNumber = 0

        val actualCellStatus = board.getCellStatus(rowNumber, columnNumber)

        assertThat(actualCellStatus).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should return invalid cell status for index out of bounds`() {
        val expectedCellStatus = INVALID
        val rowNumber = 9
        val columnNumber = 9

        val actualCellStatus = board.getCellStatus(rowNumber, columnNumber)

        assertThat(actualCellStatus).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should return invalid cell status for negative row`() {
        val expectedCellStatus = INVALID
        val rowNumber = -9
        val columnNumber = 1

        val actualCellStatus = board.getCellStatus(rowNumber, columnNumber)

        assertThat(actualCellStatus).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should return invalid cell status for negative column`() {
        val expectedCellStatus = INVALID
        val rowNumber = 4
        val columnNumber = -7

        val actualCellStatus = board.getCellStatus(rowNumber, columnNumber)

        assertThat(actualCellStatus).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should set the cell status for the given row and col`() {
        val expectedCellStatus = DEAD
        val rowNumber = 2
        val colNumber = 3

        board.setCellStatus(expectedCellStatus, rowNumber, colNumber)

        assertThat(board.playingBoard[rowNumber][colNumber]).isEqualTo(expectedCellStatus)
    }

    @Test
    fun `should do nothing when setting the cell status for negative index`() {
        val expectedBoard = board.playingBoard
        val rowNumber = -2
        val colNumber = 3

        board.setCellStatus(DEAD, rowNumber, colNumber)

        assertThat(board.playingBoard).isEqualTo(expectedBoard)
    }

    @Test
    fun `should do nothing when setting the cell status for indexes greater than  size of board`() {
        val expectedBoard = board.playingBoard
        val rowNumber = 9
        val colNumber = 3

        board.setCellStatus(DEAD, rowNumber, colNumber)

        assertThat(board.playingBoard).isEqualTo(expectedBoard)
    }

    @Test
    fun `should return the size of the board`() {
        val expectedSizeOfBoard = 6

        val actualSizeOfBoard = board.getBoardSize()

        assertThat(actualSizeOfBoard).isEqualTo(expectedSizeOfBoard)
    }
}