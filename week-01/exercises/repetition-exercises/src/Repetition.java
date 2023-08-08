import java.util.Scanner;
public class Repetition {
    public static void main(String[] args) {
        // while loop
        /*
        while (true) {
            System.out.println("This message is repeated forever.");
        }


        while (false){
            System.out.println("This message is never printed");
        }
        */
        int count = 10;
        System.out.println("Countdown:");

        while (count > 0) {
            System.out.println(count);
            count--;
        }
        System.out.println("Blast off!");

        // Loop are good for counting forward or backward
        String message = "Visit Mars.";
        int index = 0;

        while (index < message.length()){
            System.out.println(message.charAt(index));
            index = index +1;
        }

        int countdown = 10;

        System.out.println("Countdown: ");

        do {
            System.out.println(countdown);
            countdown--;
        } while (countdown > 0);
        System.out.println("Blast off again!");

        Scanner console = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter \"yes\" to accept our terms: ");
            input = console.nextLine();
        } while (!input.equalsIgnoreCase("yes"));

        System.out.println("Thank you!");

    }
}
