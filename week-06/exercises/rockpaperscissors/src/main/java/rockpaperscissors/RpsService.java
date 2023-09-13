package rockpaperscissors;

import java.util.Random;

public class RpsService {
    public enum Move{
        ROCK, PAPER, SCISSORS
    };
    public Random random = new Random();

    public String resultMessage;
    public String moveMessage;
    public void makeWinner(Move playerMove){
        // Generate random computer move
        int computerInt = random.nextInt(3);
        Move computerMove = Move.values()[computerInt];
        if(playerMove.equals(computerMove)){
            resultMessage = "Tie";
        } else if(
                playerMove.equals(Move.PAPER) && computerMove.equals(Move.SCISSORS) ||
                playerMove.equals(Move.SCISSORS) && computerMove.equals(Move.ROCK) ||
                playerMove.equals(Move.ROCK) && computerMove.equals(Move.PAPER)){
            resultMessage = "Computer wins";
        } else {
            resultMessage = "Player wins";
        }
        moveMessage = String.format("Player move: %s%n, Computer move: %s%n", playerMove, computerMove);
    }
}
