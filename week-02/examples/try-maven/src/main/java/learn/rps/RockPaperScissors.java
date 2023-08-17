package learn.rps;

import learn.rps.game.RpsEvaluator;
import learn.rps.players.CpuPlayer;
import learn.rps.players.HumanPlayer;
import learn.rps.players.Player;

import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String header = "Welcome to Rock Paper Scissors 3.2";
        System.out.println(header);
        System.out.println("=".repeat(header.length()));

        // 1. Set variable names for players
        Player playerOne = makePlayer(console);
        Player playerTwo = makePlayer(console);

        int totalGames = 0;
        int p1Wins = 0;
        int p2Wins = 0;
        boolean playAgain = false;

        public static Player makePlayer(Scanner console){
            String result;
            Player player = null;

            do{
                System.out.println("1. Human Player");
                System.out.println("2. CPU Player");
                System.out.println("Select [1-2]: ");
                result = console.nextLine();
                if(result.equals("1")){
                    System.out.println("Name?: ");
                    String name = console.nextLine();
                    player = new HumanPlayer(name);
                } else if (result.equals("2")) {
                    player = new CpuPlayer();
                } else {
                    System.out.println("That's not a valid choice.");
                }


            } while (player == null);

            return player;
        }

        // 4. Evaluate result / Outcome / Decision
        RpsEvaluator evaluator = new RpsEvaluator(playerOne, playerTwo);


        // 5.
        // 6. Play again?
        playAgain = ;

        public static int evaluate (int p1Choice, int p2Choice, String playerOne, String playerTwo)

            public static final int ROCK = 1;
            public static final int PAPER = 2;
            public static final int SCISSORS = 3;

            String outcome = "";
            int result = 0;
            if (p1Choice == p2Choice){
                outcome = "Players tied";

            }

    }
}
