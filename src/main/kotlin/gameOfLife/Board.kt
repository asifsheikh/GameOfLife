package gameOfLife

import gameOfLife.rules.CellStatus

class Board(private val sizeOfBoard: Int) : BoardInterface {

    var playingBoard = arrayOf<Array<CellStatus>>()

    override fun initialize(){
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

    fun getBoardSize(): Int = sizeOfBoard
}
