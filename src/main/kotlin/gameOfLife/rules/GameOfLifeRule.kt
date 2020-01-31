package gameOfLife.rules

enum class CellStatus {
    LIVE,
    DEAD
}

class GameOfLifeRule {
    fun checkIsAlive(currentCellStatus: CellStatus, neighbors: Array<Int>): CellStatus {
        val liveNeighbors =  neighbors
            .toList()
            .filter { it == 1 }
            .count()

        return if (liveNeighbors == 2)
            CellStatus.LIVE
        else
            CellStatus.DEAD
    }
}