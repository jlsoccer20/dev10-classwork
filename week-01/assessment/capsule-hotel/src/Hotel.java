import java.sql.SQLOutput;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {

        System.out.println("Welcome to the Capsule Hotel!");
        System.out.print("How many capsules will your hotel have? \nPlease enter a number: ");

        // Use this to take user input
        Scanner console = new Scanner(System.in);

        String userInput = console.nextLine();

        System.out.printf("\nCapsule Hotel now has %s rooms!\n", userInput);

        // convert user input to integer to match variable type
        int numCapsules = Integer.parseInt(userInput);

        // create array with numCapsules number of rooms
        // The capsules will be named by their index and contain the guest name inside (or vacant)
        String[] capsules = new String[numCapsules];


        // creating variable name outside of loop
        //String capsuleNumberCheckOutString;

        // Create and loop over main menu
        String input;
        do {
            System.out.println("\nMain Menu");
            System.out.println("-----------------");
            System.out.println("1. View Capsules");
            System.out.println("2. Check-in a guest");
            System.out.println("3. Check-out a guest");
            System.out.println("4. Exit\n");

            System.out.print("What would you like to do now?\nSelect [1-4] : ");
            input = console.nextLine();

            // 1. View Capsules
            if(input.equals("1")){

                // 1. View Capsules

                // Wish to display 10 capsules...
                displayCapsules(capsules);

                System.out.println("Which Capsule number would you like to see?\nPlease enter a number here: ");

                String userInputCapsuleNumber = console.nextLine();
                int desiredCapsuleNumber = Integer.parseInt(userInputCapsuleNumber);

                if (capsules[desiredCapsuleNumber] == null){
                    System.out.printf("Capsule %s is empty!\n", desiredCapsuleNumber);

                } else {
                    System.out.printf("Capsule %s contains guest name: %s.\n", desiredCapsuleNumber,capsules[desiredCapsuleNumber]);
                }

            } else if (input.equals("2")) {

                // 2. Check-in a Guest

                System.out.println("Please enter a guest name to check-in: ");
                String userInputGuestName = console.nextLine();

                System.out.println("Please enter a Capsule number to check into: ");
                String capsuleNumberCheckInString = console.nextLine();
                int capsuleNumberCheckIn = Integer.parseInt(capsuleNumberCheckInString);

                capsules[capsuleNumberCheckIn] = userInputGuestName;

                System.out.printf("%s has checked in to Capsule %s!\n", userInputGuestName, capsuleNumberCheckIn);
                //System.out.printf("Capsule %s contains guest name: %s\n", capsuleNumberCheckIn,capsules[capsuleNumberCheckIn]);

            } else if (input.equals("3")){
                System.out.println("Check-out guest from capsule number: ");
                String capsuleNumberCheckOutString = console.nextLine();

                int capsuleNumberCheckOutInt = Integer.parseInt(capsuleNumberCheckOutString);


                // Validate answer
                if (capsules[capsuleNumberCheckOutInt] == null){
                    System.out.printf("Capsule %s is already empty!\n", capsuleNumberCheckOutString);

                } else {

                    System.out.printf("Guest has now been checked out of Capsule %s.\n", capsuleNumberCheckOutString);

                    // Set capsule number to empty
                    capsules[capsuleNumberCheckOutInt] = null;
                    //System.out.printf("Capsule %s contains guest name: %s", desiredCapsuleNumber,capsules[desiredCapsuleNumber]);
                }



            } else if (input.equals("4")){

                // Typing n does not actually prevent the game from exiting!!!
                System.out.println("Are you sure you would like to exit? All data will be lost. [y/n]");
                String exitCapsuleHotel = console.nextLine();
                    if (exitCapsuleHotel.equals("y")){
                        System.out.println("Thank you for visiting the Capsule Hotel. Goodbye!");
                        break;
                    }

            } else {
                System.out.println("That is not a valid command! Please pick a number between 1 and 4!");
            }

        } while (!input.equals("4"));




        //System.out.println(capsules);

        // Prompt user input (int)
        // Validate input (please enter a number, banana is not a number)

        /*
        int[] menuOptions = new int[5];

        // Display Main Menu
        // -----------------
        // 1. View Capsules
        // 2. Check-in a guest
        // 3. Check-out a guest
        // 4. Exit

        String mainMenu;
        switch(mainMenu) {
            case 1:
            // 1. View Capsules
                System.out.println("Please enter the capsule number you wish to view: ");

            // Validate number
            // Display error message if number is higher or lower than capsule number range (0 - 100).

            // if capsule wanting to be viewed is less than 5 or greater than 95, display 0-11 or 89-100, respectively.

            // What would you like to do now? --> prompt main menu
                break;

            case 2:
            // 2. Check-in Guest

            // Prompt user input
            // String guestName = (input)

            // Prompt user input
            // int desiredCapsule = capsule(input)

            // Check if capsule is already occupied
            // If occupied, display message
            // System.out.printf("Sorry, Capsule %s is already taken!", desiredCapsule);

            // If not occupied, display message
            // System.out.printf("You are now checked in to the Capsule Hotel. Enjoy your stay, %s", name);

                break;

            case 3:
            // Case 3
            // 3. Check-out Guest

            // Prompt user input
                System.out.print("Which capsule would you like to check out of?");

            // int desiredCapsule = (input);

            // String vacancyStatus
                System.out.printf("Capsule %s is %s.", desiredCapsule, vacancyStatus);


            // Method: Check vacancy of room
                int desiredCapsule = (input);
                boolean vacancyStatus; // output
                System.out.printf("Capsule %s is %s.", desiredCapsule, vacancyStatus);

                break;

            case 4:
            // Case 4
            // 4. Exit
                System.out.println("Do you wish to exit? All data will be deleted. [y/n]");
                break;

    }

         */
    }

    static void displayCapsules(String[] capsules){
        System.out.println("Guests");
        for (int i = 0; i < capsules.length; i++){
            System.out.printf("Capsule %s: %s%n", i + 1, capsules[i] == null ? "[Unoccupied]" : capsules[i]);
        }
    }
}
