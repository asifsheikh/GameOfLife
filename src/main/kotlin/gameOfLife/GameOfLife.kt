package gameOfLife

import gameOfLife.board.GameOfLifeBoard
import gameOfLife.rules.GameOfLifeRule

class GameOfLife(private val board: GameOfLifeBoard, private val rules: GameOfLifeRule) {
    fun play() {
        board.printCurrentBoard()
        while (true) {
            board.applyRules(rules)
            board.printCurrentBoard()
        }
    }
}
