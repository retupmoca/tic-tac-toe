#' Play tic-tac-toe!
#'
#' Invoke an interactive text-based tic-tac-toe game.
#'
#' If you enter 'computer' as a player name, you can play against a bot.
#'
#' @export
tic_tac_toe <- function () {
  turn <- 0
  winner <- FALSE
  board <- matrix(0,3,3)

  # Welcome screen
  print_message(welcome)

  # Get player names
  players <- get_player_names()

  # Are any of the players bots?
  bot <- check_for_bot(players)

  # And start the game off with player 1
  print_message("OK ", players[1], ", let's get started", "\n")

  # Show the  player the board
  draw_board(board)

  while (!winner && turn < 9) {

    # Determine which player gets a turn
    active_player <- get_active_player(turn)

    # Get coordinates of next turn
    if (turn == 8) {
      coords <- which(board == 0)
    } else {
      coords <- ifelse(bot[active_player],
                       get_bot_move(board, active_player),
                       get_player_move(players[active_player]))
    }

    # Apply the move the the board
    if (board[coords] == 0) {
      board[coords] <- get_player_marker(active_player)
    } else {
      print_message("Sorry, that spot is taken!!! Try again...")
      next()
    }

    # Either confirm receipt of coords or tell them one move left.
    print_message(get_confirm_message(players[active_player], turn))

    # Show the player the changes
    draw_board(board)

    # Check for winner
    winner <- check_for_winner(board)

    # Increment turn number
    turn <- turn + 1
  }

  if (winner)  {
    print_message("\nWell played, ", players[active_player], ". You've won!!!")
  } else {
    print_message("It was a draw. Better luck next time.")
  }

  invisible(0)

}
