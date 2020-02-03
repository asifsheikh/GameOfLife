package gameOfLife.board

import gameOfLife.rules.CellStatus
import gameOfLife.rules.CellStatus.*

internal const val SIZE_OF_BOARD = 6

class GameOfLifeBoardImpl : GameOfLifeBoard {

    private var playingBoard = arrayOf<Array<CellStatus>>()

    init {
        playingBoard = getDefaultPlayingBoard()
    }

    override fun getBoard(): Array<Array<CellStatus>> = playingBoard.copyOf()

    override fun getCellStatus(rowNumber: Int, columnNumber: Int): CellStatus =
        if (rowNumber < 0 || columnNumber < 0) {
            INVALID
        } else if (rowNumber < SIZE_OF_BOARD && columnNumber < SIZE_OF_BOARD) {
            playingBoard[rowNumber][columnNumber]
        } else INVALID

    override fun setCellStatus(cellStatus: CellStatus, rowNumber: Int, colNumber: Int) {
        if (rowNumber < 0 || colNumber < 0) return
        if (rowNumber >= SIZE_OF_BOARD || colNumber >= SIZE_OF_BOARD) return
        playingBoard[rowNumber][colNumber] = cellStatus
    }

    override fun applyRules(checkIsAliveRule: (CellStatus, IntArray) -> CellStatus) {
        var newBoard = arrayOf<Array<CellStatus>>()
        for (i in 0 until SIZE_OF_BOARD) {
            var array = arrayOf<CellStatus>()
            for (j in 0 until SIZE_OF_BOARD) {
                 array += checkIsAliveRule(playingBoard[i][j], getNeighbors(i, j))
            }
             newBoard += array
        }
        playingBoard = newBoard
    }

    fun getNeighbors(row: Int, column: Int): IntArray {
        val neighbors = IntArray(8)
        neighbors[0] = getNeighbor(row, column - 1)
        neighbors[1] = getNeighbor(row, column + 1)
        neighbors[2] = getNeighbor(row - 1, column)
        neighbors[3] = getNeighbor(row + 1, column)
        neighbors[4] = getNeighbor(row - 1, column - 1)
        neighbors[5] = getNeighbor(row - 1, column + 1)
        neighbors[6] = getNeighbor(row + 1, column - 1)
        neighbors[7] = getNeighbor(row + 1, column + 1)
        return neighbors
    }

    private fun getNeighbor(row: Int, column: Int): Int {
        return if (isValidIndex(row, column)) {
            when (playingBoard[row][column]) {
                LIVE -> 1
                else -> 0
            }
        } else {
            0
        }
    }

    private fun isValidIndex(row: Int, column: Int): Boolean {
        if (row < 0 || column < 0) return false
        if (row >= SIZE_OF_BOARD || column >= SIZE_OF_BOARD) return false
        return true
    }
}

private fun getDefaultPlayingBoard(): Array<Array<CellStatus>> {
    var defaultBoard = arrayOf<Array<CellStatus>>()
    defaultBoard += arrayOf(DEAD, DEAD, DEAD, DEAD, DEAD, DEAD)
    defaultBoard += arrayOf(DEAD, DEAD, LIVE, DEAD, DEAD, DEAD)
    defaultBoard += arrayOf(DEAD, DEAD, LIVE, DEAD, DEAD, DEAD)
    defaultBoard += arrayOf(DEAD, DEAD, LIVE, DEAD, DEAD, DEAD)
    defaultBoard += arrayOf(DEAD, DEAD, DEAD, DEAD, DEAD, DEAD)
    defaultBoard += arrayOf(DEAD, DEAD, DEAD, DEAD, DEAD, DEAD)
    return defaultBoard
}
