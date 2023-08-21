import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame>.
        ArrayList<BoardGame> jessicasGames = new ArrayList<>();

        // 2. Add three BoardGames to the new list.
        jessicasGames.add(new BoardGame("Alles Nuscht", 2, 100, "Nuuuscht"));
        jessicasGames.add(new BoardGame("Shocken", 2, 9, "Woooo Ooooh!"));
        jessicasGames.add(new BoardGame("Siedler von Catan", 3, 5, "Get mad at each other while selling your sheep"));
        // 3. Print the new list.
        System.out.println(jessicasGames);


        // 4. Add items in the new list to `games` with the `addAll` method.
        games.addAll(jessicasGames);

        // 5. Print `games`.
        System.out.println("\nLearning how to make For Loops 1: ");
        for (BoardGame game : games){
            System.out.println(game.getName());
        }
        System.out.println("\nLearning how to make For Loops 2: ");
        for (int i = 0; i < games.size(); i++) {
            BoardGame game = games.get(i);
            System.out.println(game.getName());
        }

        System.out.println("\nLearning how to make For Loops 3: ");
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i).getName());
        }



        //BoardGame objectBoardGame = games.get(0).getName();

    }
}
