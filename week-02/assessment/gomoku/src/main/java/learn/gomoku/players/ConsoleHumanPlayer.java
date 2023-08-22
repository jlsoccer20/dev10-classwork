package learn.gomoku.players;

import learn.gomoku.game.Stone;

import java.util.List;
import java.util.Scanner;

public class ConsoleHumanPlayer extends HumanPlayer {

    public ConsoleHumanPlayer(String name) {
        super(name);
    }


    @Override
    public Stone generateMove(List<Stone> previousMoves) {
        Scanner console = new Scanner(System.in);

        System.out.println("enter a row: ");  //, currentPlayer.getName()); // Want to use the current player's name here
        int row = Integer.parseInt(console.nextLine());

        System.out.println("Enter a column: ");
        int column = Integer.parseInt(console.nextLine());

        // Code adapted from RandomPlayer
        boolean isBlack = true;
        if (previousMoves != null && !previousMoves.isEmpty()) {
            Stone lastMove = previousMoves.get(previousMoves.size() - 1);
            isBlack = !lastMove.isBlack();
        }

        // Stone (int row, int column, boolean isBlack)
        return new Stone(row, column, isBlack);
    }
}
