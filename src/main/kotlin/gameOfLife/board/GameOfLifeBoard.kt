package gameOfLife.board

import gameOfLife.rules.CellStatus

interface GameOfLifeBoard {
    fun getBoard() : Array<Array<CellStatus>>
    fun setCellStatus(cellStatus: CellStatus, rowNumber: Int, colNumber: Int)
    fun getCellStatus(rowNumber: Int, colNumber: Int): CellStatus
    fun applyRules(rules: (CellStatus, IntArray) -> CellStatus)
}
