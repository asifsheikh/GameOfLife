package gameOfLife.rules

import gameOfLife.rules.CellStatus.*

enum class CellStatus {
    LIVE,
    DEAD
}

class GameOfLifeRule {
    fun checkIsAlive(currentCellStatus: CellStatus, neighbors: Array<Int>): CellStatus {
        val liveNeighbors = getLiveNeighbor(neighbors)
        return when (currentCellStatus) {
            LIVE -> checkForAliveForLiveCell(liveNeighbors)
            DEAD -> checkForAliveForDeadCell(liveNeighbors)
        }
    }

    private fun getLiveNeighbor(neighbors: Array<Int>): Int = neighbors
        .toList()
        .filter { it == 1 }
        .count()

    private fun checkForAliveForLiveCell(liveNeighborCount: Int): CellStatus {
        if (liveNeighborCount == 2 || liveNeighborCount == 3) return LIVE
        return DEAD
    }

    private fun checkForAliveForDeadCell(liveNeighborCount: Int): CellStatus {
        if (liveNeighborCount == 3) return LIVE
        return DEAD
    }
}
