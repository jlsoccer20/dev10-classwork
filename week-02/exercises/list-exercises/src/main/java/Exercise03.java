import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Add three new games to `games` with the `add` method.

        // Not quite what was intended, but it worked, so we smile
        for (int i=0; i<3; i++){
            games.add(new BoardGame ("Tempel des Schreckens", 5,10,"Strategy"));
            System.out.printf(games + "\n");
        }

        games.add(new BoardGame("Siedler von Catan", 3, 10, "Get mad at each other selling your sheep"));
        // 2. Print `games` after each add.
        System.out.println(games);
        games.add(new BoardGame("Shocken", 2, 100000, "Say woooo oohh"));
        System.out.println(games);
        games.add(new BoardGame("Alles Nuscht", 3, 10, "Nuscht"));
        System.out.println(games);
    }
}
