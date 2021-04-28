package board

import board.Direction.*
import java.lang.IllegalArgumentException
import board.*

fun createSquareBoard(width: Int): SquareBoard = object : SquareBoard{
    override val width: Int = width
    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if(i > width || j > width) null
        else getCell(i,j)
    }

    override fun getCell(i: Int, j: Int): Cell {
        if(i <= 0 || j <= 0) throw IllegalArgumentException()
        return Cell(i, j)
    }

    override fun getAllCells(): Collection<Cell> {
        val list:ArrayList<Cell> = ArrayList()
        for (i in 1..width){
            for(j in 1..width){
                list.add(Cell(i,j))
            }
        }
        return list

    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("Not yet implemented")
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("Not yet implemented")
    }

}
fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

