package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.ConsoleHumanPlayer;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Scanner console = new Scanner(System.in);

    // if needed: Gomoku.WIDTH

    // Method with return type "void" - no return
    public void run(){

        System.out.println("\n________________\nWelcome to Gomoku!\n________________");

        // create variable "game" of type "Gomoku" as the return value of setUp()
        Gomoku game = setUp();

        // variable name "result" stores the result of the game, type "Result"
        Result result;

        // board to display to the user
        char[][] board = new char[Gomoku.WIDTH][Gomoku.WIDTH];
        for (char[] row : board){
            Arrays.fill(row, '_'); // get rid of null character
        }
        do {

            Player currentPlayer = game.getCurrent();
            System.out.printf("\n______________\n%s's turn\n______________\n%s, ", currentPlayer.getName(), currentPlayer.getName());

            // display the board


            Stone stone = currentPlayer.generateMove(game.getStones());

            // Check validity of the turn here


            System.out.printf("Stone was placed at row: %s, column: %s\n", stone.getRow(), stone.getColumn());

            result = game.place(stone);


            if (result.isSuccess()) {
                board[stone.getRow()][stone.getColumn()] = game.isBlacksTurn() ? 'X' : 'O';
                System.out.print("    ");
                // show board
                for (int colNumber = 1; colNumber <= Gomoku.WIDTH; colNumber++){
                    // Displays the Column Numbers (01 - 15)
                    System.out.printf("%02d ", colNumber);
                }
                for (int rowIndex = 0; rowIndex < Gomoku.WIDTH; rowIndex++){
                    // Displays the Row Numbers (01 - 15)
                    System.out.printf("\n%02d ", rowIndex+1);

                        // Displays the board
                        System.out.printf(Arrays.toString(board[rowIndex]));

                }
            }

        } while (!game.isOver());

        System.out.printf("\n________________________________\n%s\n________________________________", result.getMessage()); // End game message



    }

    // Method with return type "Gomoku"
    private Gomoku setUp() {

        // Create a new array named "players" of size 2 with type "Player" (Interface)
        Player[] players = new Player[2];

    // "for loop" syntax:
    // for (start, how long to repeat loop, what to do at the end of each loop)
        //  Start with player 1,
        //                         boolean condition that needs to be true for loop to run
        //                                            playerNumber = playerNumber + 1 (add 1 each loop)
        for (int playerNumber = 1; playerNumber <= 2; playerNumber++) {

            // Prompt the user to select a 1. Human or 2. Random (CPU)
            System.out.printf("Player %s is: \n1. Human\n2. Random Player (CPU)\nSelect [1-2]: ", playerNumber);
            int selection = Integer.parseInt(console.nextLine());

            // switch (depending on what is given)
            switch (selection) {
                // if selection = 1, Human Player
                case 1:
                    players[playerNumber-1] = createConsoleHumanPlayer();
                    // required break to stop switch from going to next case(s)
                    break;
                // if selection = 2, Random Player (CPU)
                case 2:
                    players[playerNumber-1] = new RandomPlayer();
                    break;
                default:
                    System.out.println("Invalid input.");
                    // Negates the +1 of the for loop, making it do this again
                    // playerNumber = playerNumber - 1;
                    playerNumber--;
                    break;
            }
        }

        // Type Class (named Gomoku)
        // variable name "game"
        // Set up "game" by giving parameters (player1, player2) to the Gomoku constructor
        Gomoku game = new Gomoku(players[0], players[1]);

        System.out.printf("\n%s versus %s", players[0].getName(), players[1].getName());
        System.out.printf("\nRandomizing...\n%s (black) starts!\n", game.getCurrent().getName());

        return game;
    }

    // Method with return type "ConsoleHumanPlayer" (Class)
    private HumanPlayer createConsoleHumanPlayer() {
        System.out.println("Player name: ");
        String name = console.nextLine();

        //System.out.printf("Player is: %s\n", name);

        return new ConsoleHumanPlayer(name);
    }






}
