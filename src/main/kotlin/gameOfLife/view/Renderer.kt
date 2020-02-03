package gameOfLife.view

import gameOfLife.board.GameOfLifeBoard

interface Renderer {
    fun onRender(board: GameOfLifeBoard)
}

class CLIRenderer : Renderer {
    override fun onRender(board: GameOfLifeBoard) {
        val playingBoard = board.getBoard()
    }
}