package lld.ttt

class Board(val size: Int) {

    private val board = Array(size) { CharArray(size) { ' ' } }
    private var moves = 0

    fun isValidMove(row: Int, col: Int): Boolean {
        return row in 0 until size &&
                col in 0 until size &&
                board[row][col] == ' '
    }

    fun makeMove(row: Int, col: Int, symbol: Char) {
        board[row][col] = symbol
        moves++
    }

    fun checkWin(symbol: Char): Boolean {

        // rows
        for (i in 0 until size) {
            if ((0 until size).all { board[i][it] == symbol }) return true
        }

        // columns
        for (i in 0 until size) {
            if ((0 until size).all { board[it][i] == symbol }) return true
        }

        // diagonal
        if ((0 until size).all { board[it][it] == symbol }) return true

        // anti diagonal
        if ((0 until size).all { board[it][size - it - 1] == symbol }) return true

        return false
    }

    fun isDraw(): Boolean {
        return moves == size * size
    }

    fun printBoard() {

        for (i in 0 until size) {
            for (j in 0 until size) {
                print(" ${board[i][j]} ")
                if (j != size - 1) print("|")
            }
            println()

            if (i != size - 1) {
                println("---+---+---")
            }
        }
    }
}