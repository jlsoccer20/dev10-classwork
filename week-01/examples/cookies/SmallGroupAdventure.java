import java.util.Scanner;
import java.util.Random;
public class SmallGroupAdventure {
    public static void main(String[] args) {
        // Hide and seek
        // Search for a room (Room 1, Room 2, ... Room n)
        // Search for a location inside a room (Location 1, Location 2)
        // Losing condition: countdown of attempts
        // Win condition: guess the right number (with "lives" still left)
        // random number generator
        boolean hasWon = false;
        Random rand = new Random();
        int winningRoom = rand.nextInt(5) + 1; //range? add 1 to skip 0
        //int winningRoom = 1;

        int numLives = 3;
        System.out.printf("There are five rooms. Where is the prize hiding? You have %s attempts.", numLives);
        //System.out.println("\nPick a room: ");

        Scanner console = new Scanner(System.in);

        int roomNumber;

        while(numLives > 0 && !hasWon){
            System.out.println("\nPick a room: ");

            // takes input, converts string to int
            roomNumber= Integer.parseInt(console.nextLine());

            if (roomNumber != winningRoom){

                switch(roomNumber) {
                    case 1:
                        System.out.println("You are now in Room 1");
                        numLives--;
                        System.out.printf("You have %s lives left.", numLives);
                        break;
                    case 2:
                        System.out.println("You are now in Room 2");
                        numLives--;
                        System.out.printf("You have %s lives left.", numLives);
                        break;
                    case 3:
                        System.out.println("You are now in Room 3");
                        numLives--;
                        System.out.printf("You have %s lives left.", numLives);
                        break;
                    case 4:
                        System.out.println("You are now in Room 4");
                        numLives--;
                        System.out.printf("You have %s lives left.", numLives);
                        break;
                    case 5:
                        System.out.println("You are now in Room 5");
                        numLives--;
                        System.out.printf("You have %s lives left.", numLives);
                        break;
                }
                if (numLives == 0){
                    System.out.println("You ran out of lives. You lose!");
                }
            } else {
                System.out.println("You win!");
                hasWon = true;
            }
        }
    }
}
