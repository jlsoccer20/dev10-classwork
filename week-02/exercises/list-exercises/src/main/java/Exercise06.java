import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise06 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Use a loop to find the game in `games` that can be played by the most players.
        // 2. Print the game. (Expected: "Ultimate Werewolf...")

        // Store the max player game so far
        BoardGame gameWithMaxPlayers = games.get(0);

        for (int i = 0; i < games.size(); i++){
            // Check if current game's maxPlayers is greater than gameWithMaxPlayers maxPlayers
            System.out.println(games.get(i).getMaxPlayers());
            if(games.get(i).getMaxPlayers()> gameWithMaxPlayers.getMaxPlayers()){
                gameWithMaxPlayers = games.get(i);
            }
            // If it is, set gameWithMaxPlayers equal to current game
        }

        // Enhanced for-loop (Read as "for each board game in games")
        //for (BoardGame bg : games){
        //System.out.println(bg.getMaxPlayers());
    }
}

