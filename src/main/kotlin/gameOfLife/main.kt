package gameOfLife

import gameOfLife.board.GameOfLifeBoardImpl
import gameOfLife.rules.checkIsAlive

fun main() {
    val board = GameOfLifeBoardImpl()
    val game = GameOfLife(gameOfLifeBoard = board, gameOfLifeRules = ::checkIsAlive)
    game.play()
}