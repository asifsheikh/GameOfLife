package gameOfLife

import gameOfLife.board.GameOfLifeBoardImpl
import gameOfLife.rules.checkIsAlive
import gameOfLife.view.CLIRenderer

fun main() {
    val board = GameOfLifeBoardImpl()
    val viewRenderer = CLIRenderer()
    val game = GameOfLife(gameOfLifeBoard = board, gameOfLifeRules = ::checkIsAlive, viewRenderer = viewRenderer)
    game.play()
}