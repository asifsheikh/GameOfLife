package gameOfLife

import gameOfLife.board.GameOfLifeBoard
import gameOfLife.rules.CellStatus

class GameOfLife(
    private val gameOfLifeBoard: GameOfLifeBoard,
    private val gameOfLifeRules: (CellStatus, IntArray) -> CellStatus
) {
    fun play() {
        for (i in 1..4) {
            gameOfLifeBoard.printBoard()
            gameOfLifeBoard.applyRules(rules = gameOfLifeRules)
            println()
        }
    }
}
