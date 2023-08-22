package learn.gomoku;

import learn.gomoku.ui.Controller;
import learn.gomoku.ui.GameController;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Controller controller = new Controller();

        Scanner console = new Scanner(System.in);
        String playAgain;
        do {
            controller.run();
            // Prompt to play again
            System.out.println("\nWould you like to play again? [y/n]: ");
            playAgain = console.nextLine();
        } while (playAgain.equals("y"));


    }
}
