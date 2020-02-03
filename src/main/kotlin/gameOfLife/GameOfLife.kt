package gameOfLife

import gameOfLife.board.GameOfLifeBoard
import gameOfLife.rules.CellStatus
import gameOfLife.view.GameOfLifeView
import javax.swing.Renderer

class GameOfLife(
    private val gameOfLifeBoard: GameOfLifeBoard,
    private val gameOfLifeRules: (CellStatus, IntArray) -> CellStatus,
    private val viewRenderer: GameOfLifeView
) {
    fun play() {
        for (i in 1..4) {
            viewRenderer.onRender(board = gameOfLifeBoard)
            gameOfLifeBoard.applyRules(rules = gameOfLifeRules)
            println()
        }
    }
}
