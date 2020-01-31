package gameOfLife

import gameOfLife.rules.CellStatus

interface BoardInterface {
    fun initialize()
    fun printCurrentBoard()
    fun setCellStatus(cellStatus: CellStatus, rowNumber: Int, colNumber: Int)
    fun getCellStatus(rowNumber: Int, colNumber: Int): CellStatus
}