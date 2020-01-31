package gameOfLife.board

import gameOfLife.rules.CellStatus
import gameOfLife.rules.GameOfLifeRule

interface GameOfLifeBoard {
    fun printCurrentBoard()
    fun setCellStatus(cellStatus: CellStatus, rowNumber: Int, colNumber: Int)
    fun getCellStatus(rowNumber: Int, colNumber: Int): CellStatus
    fun applyRules(rules:GameOfLifeRule)
}