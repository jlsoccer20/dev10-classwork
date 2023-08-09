//import java.util.Scanner;
//
//public class TextAdventure {
//    public static void main(String[] args) {
//        // Room 1 - Office - Start Here
//        // Room 2 - Hallway
//        // Room 3 - Kitchen
//
//        System.out.println("Welcome to the office! Do you have what it takes to retrieve a cookie?");
//
//        String currentRoom = "office";
//        boolean hasCookie = false;
//        boolean leftTheOffice = false;
//        boolean exit = false;
//
//        Scanner console = new Scanner(System.in);
//        String choice;
//
//        while(!hasCookie || currentRoom.equals("office")){
//            switch (currentRoom){
//                case "office":
//                    if (hasCookie){
//                        System.out.println("You win! Enjoy that cookie!");
//                        exit = true;
//                    } else if (leftTheOffice){
//                        System.out.println("You returned without a cookie. You lose!");
//                        exit = true;
//                    } else{
//                    }
//
//                do {
//                    System.out.printf("You are in the %s. What would you like to do?", currentRoom);
//                    System.out.println("1. Look around.");
//                    System.out.println("2. Go to the hallway.");
//                    System.out.print("Choose [1-2]: ");
//                    choice = console.nextLine();
//                    if (choice.equals("1")) {
//                        System.out.println("Nothing of interest.");
//                    } else if (choice.equals("2")) {
//                        System.out.println("Good choice! Entering the Hallway.");
//                        currentRoom = "hallway";
//                    } else {
//                        System.out.println("Please choose 1 or 2.");
//                    }
//
//                } while(!choice.equals("1") && !choice.equals("2"));
//
//                break;
//                case "hallway":
//                    do{
//                        System.out.printf("You are in the %s. What would you like to do?", currentRoom);
//                        System.out.println("1. Look around.");
//                        System.out.println("2. Go to the office.");
//                        System.out.println("3. Go to the kitchen.");
//                        System.out.print("Choose [1-3]: ");
//
//                        choice = console.nextLine();
//
//                        if (choice.equals("1")) {
//                            System.out.println("Nothing of interest.");
//                        } else if (choice.equals("2")){
//                            currentRoom = "office";
//                        } else if (choice.equals("3")){
//                            currentRoom = "kitchen";
//                        }
//
//                        //String
//                        break;
//                    }
//
//            }
//
//        }
//
//
//    }
//}
