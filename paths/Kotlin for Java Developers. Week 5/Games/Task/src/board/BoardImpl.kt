package board

import board.Direction.*
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)

fun <T> createGameBoard(width: Int): GameBoard<T> = object :GameBoard<T>, SquareBoardImpl(width){

    val gameBoardMap:LinkedHashMap<Cell, T?> = LinkedHashMap(width*width)
    init {
        for(i in 1..width){
            for (j in 1..width){
                gameBoardMap[getCell(i, j)] = null
            }
        }
    }

    override fun get(cell: Cell): T? {
        return gameBoardMap[cell]
    }

    override fun set(cell: Cell, value: T?) {
        gameBoardMap[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return gameBoardMap.filter{predicate(it.value)}.map { it.key }
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return gameBoardMap.filter { predicate(it.value) }.keys.first()
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        gameBoardMap.forEach{println(it)}
        return gameBoardMap.any { predicate(it.value) }
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return gameBoardMap.all { predicate(it.value) }
    }
}

open class SquareBoardImpl(width: Int):SquareBoard{
    override val width: Int = width
    private val cells = LinkedList<LinkedList<Cell>>()

    init {
        for (i in 1..width) {
            val aux = LinkedList<Cell>()
            for (j in 1..width) {
                aux.add(Cell(i, j))
            }
            cells.add(aux)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if(i > width || j > width || i <= 0 || j <= 0) null
        else getCell(i,j)
    }

    override fun getCell(i: Int, j: Int): Cell {
        if(i < 1 || j < 1 ||
            i > width || j > width) throw IllegalArgumentException()
        return cells[i-1][j-1]
    }

    override fun getAllCells(): Collection<Cell> {
        val list:ArrayList<Cell> = ArrayList()
        for (i in 1..width){
            for(j in 1..width){
                list.add(getCell(i,j))
            }
        }
        return list
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {

        val list:ArrayList<Cell> = ArrayList()
        for(j in jRange){
            if(j > width) break
            list.add(getCell(i, j))
        }
        return list
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val list:ArrayList<Cell> = ArrayList()
        for(i in iRange){
            if(i > width) break
            list.add(getCell(i, j))
        }
        return list
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            UP -> getCellOrNull(this.i -1, this.j)
            LEFT -> getCellOrNull(this.i, this.j - 1)
            DOWN -> getCellOrNull(this.i + 1, this.j)
            RIGHT -> getCellOrNull(this.i, this.j + 1)
        }
    }

}

