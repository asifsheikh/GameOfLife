package gameOfLife.board

import gameOfLife.rules.CellStatus
import gameOfLife.rules.GameOfLifeRule

class GameOfLifeBoardImpl(private val sizeOfBoard: Int) : GameOfLifeBoard {

    var playingBoard = arrayOf<Array<CellStatus>>()

    override fun initialize() {
        for (i in 1..sizeOfBoard) {
            var array = arrayOf<CellStatus>()
            for (j in 1..sizeOfBoard) {
                array += CellStatus.LIVE
            }
            playingBoard += array
        }
    }

    override fun printCurrentBoard() {
        for (row in playingBoard) {
            for (cell in row) {
                print("$cell ")
            }
            println()
        }
    }

    override fun getCellStatus(rowNumber: Int, columnNumber: Int): CellStatus =
        if (rowNumber < 0 || columnNumber < 0) {
            CellStatus.INVALID
        } else if (rowNumber < sizeOfBoard && columnNumber < sizeOfBoard) {
            playingBoard[rowNumber][columnNumber]
        } else CellStatus.INVALID

    override fun setCellStatus(cellStatus: CellStatus, rowNumber: Int, colNumber: Int) {
        if (rowNumber < 0 || colNumber < 0) return
        if (rowNumber >= sizeOfBoard || colNumber >= sizeOfBoard) return
        playingBoard[rowNumber][colNumber] = cellStatus
    }

    override fun getBoardSize(): Int = sizeOfBoard

    override fun applyRules(rules: GameOfLifeRule) {
        val newBoard = arrayOf<Array<CellStatus>>()
        for (i in 0 until sizeOfBoard) {
            var array = arrayOf<CellStatus>()
            for (j in 0 until sizeOfBoard) {
                array += rules.checkIsAlive(playingBoard[i][j], getNeighbors(i,j))
            }
            playingBoard += array
        }
        playingBoard = newBoard
    }

    private fun getNeighbors(row: Int, column: Int): IntArray {
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
                CellStatus.LIVE -> 1
                else -> 0
            }
        } else {
            0
        }
    }

    private fun isValidIndex(row: Int, column: Int): Boolean {
        if (row < 0 || column < 0) return false
        if (row >= sizeOfBoard || column >= sizeOfBoard) return false
        return true
    }
}
