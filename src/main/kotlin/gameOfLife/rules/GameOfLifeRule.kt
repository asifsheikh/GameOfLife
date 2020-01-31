package gameOfLife.rules

import gameOfLife.rules.CellStatus.*

enum class CellStatus(private val symbol: String) {
    LIVE("*"),
    DEAD("-"),
    INVALID("$");

    override fun toString(): String {
        return symbol
    }
}

fun checkIsAlive(currentCellStatus: CellStatus, neighbors: IntArray): CellStatus {
    val liveNeighbors = getLiveNeighbor(neighbors)
    return when (currentCellStatus) {
        LIVE -> checkForAliveForLiveCell(liveNeighbors)
        DEAD -> checkForAliveForDeadCell(liveNeighbors)
        INVALID -> currentCellStatus
    }
}

private fun getLiveNeighbor(neighbors: IntArray): Int = neighbors
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

