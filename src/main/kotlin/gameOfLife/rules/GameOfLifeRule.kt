package gameOfLife.rules

enum class CellStatus {
    LIVE,
    DEAD
}

class GameOfLifeRule {
    fun checkIsAlive(currentCellStatus: CellStatus, neighbors: Array<Int>): CellStatus {
        val liveNeighbors = neighbors
            .toList()
            .filter { it == 1 }
            .count()

        return if (currentCellStatus == CellStatus.LIVE && (liveNeighbors == 2 || liveNeighbors == 3))
            CellStatus.LIVE
        else if (currentCellStatus == CellStatus.DEAD && liveNeighbors == 3)
            return CellStatus.LIVE
        else
            CellStatus.DEAD
    }
}
