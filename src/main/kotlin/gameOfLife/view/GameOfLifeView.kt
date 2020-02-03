package gameOfLife.view

import gameOfLife.board.GameOfLifeBoard

interface GameOfLifeView {
    fun onRender(board: GameOfLifeBoard)
}

class CLIRenderer : GameOfLifeView {
    override fun onRender(board: GameOfLifeBoard) {
        val playingBoard = board.getBoard()
        for (row in playingBoard) {
            for (cell in row) {
                print("$cell ")
            }
            println()
        }
    }
}