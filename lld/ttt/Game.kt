package lld.ttt



class Game(
    val board: Board,
    val players: List<Player>
) {
    fun startGame() {

        while (true) {

            for (player in players) {

                board.printBoard()

                println("${player.name} turn (${player.symbol})")
                print("Enter row and column: ")

                val input = readLine()!!.split(" ")
                val row = input[0].toInt()
                val col = input[1].toInt()

                if (!board.isValidMove(row, col)) {
                    println("Invalid move. Try again.")
                    continue
                }

                board.makeMove(row, col, player.symbol)

                if (board.checkWin(player.symbol)) {
                    board.printBoard()
                    println("${player.name} wins!")
                    return
                }

                if (board.isDraw()) {
                    board.printBoard()
                    println("Game Draw!")
                    return
                }
            }
        }
    }
}

fun main() {
    val players = listOf(
        Player("Player1", 'X'),
        Player("Player2", 'O')
    )
    val board = Board(3)
    val game = Game(board, players)
    game.startGame()
}