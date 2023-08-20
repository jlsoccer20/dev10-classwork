package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;

import java.util.Scanner;
import java.util.Set;

public class GameController {

    private final Scanner console = new Scanner(System.in);

    // if needed: Gomoku.WIDTH

    public void run(){
        System.out.println("\n________________\nWelcome to Gomoku!\n________________");
        setUp();
        /*
        while (!isOver){
            // code here
        }
        */
    }

    private void setUp() {

        System.out.println("Player 1 is: \n1. Human\n2. Random Player (CPU)\nSelect [1-2]: ");
        int selection = Integer.parseInt(console.nextLine());

        int hasTwoPlayers = 0;
        do{
            if (selection == 1) {
                System.out.println("Human Player");

                if (hasTwoPlayers <1){
                    createHumanPlayerOne();

                } else {
                    createHumanPlayerTwo();
                }
                hasTwoPlayers +=1;

            } else if (selection == 2) {
                System.out.println("Random Player");
                hasTwoPlayers +=1;

            } else {
                System.out.println("That's not a valid choice.");
            }
        } while (hasTwoPlayers < 2);



    }
    private HumanPlayer createHumanPlayerOne() {
        // Player 1
        System.out.println("Player 1 name: ");
        String name = console.nextLine();

        HumanPlayer playerOne = new HumanPlayer(name);
        System.out.printf("Player 1 is: %s\n", playerOne.getName());

        return playerOne;
    }

    private HumanPlayer createHumanPlayerTwo(){

        // Player 2
        System.out.println("Player 2 name: ");
        String name = console.nextLine();

        HumanPlayer playerTwo = new HumanPlayer(name);
        System.out.printf("Player 2 is: %s", playerTwo.getName());

        return playerTwo;
    }



}
