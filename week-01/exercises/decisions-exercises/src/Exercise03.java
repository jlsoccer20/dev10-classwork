import java.util.Scanner;
public class Exercise03 {

    public static void main(String[] args) {
        // 1. Change the code to accept input from the user.
        // Use a Scanner and parse the input with Integer.parseInt.

        // System.in is used for getting input from user
        Scanner console = new Scanner(System.in); // not a primitive type, needs "new"

        // Solution 1
        // (ctrl + / to block comment)

        // System.out.print("Enter a number: ");

        // console calls for input
        // nextLine() says wait until reads "\n" off the string
        // String input = console.nextLine();

        // convert string to int
//        int value = Integer.parseInt(input);


//        if (value >= 10 && value < 26) {
//
//            // System.out makes output to print
//            System.out.println("Value is in the acceptable range.");
//        } else {
//            System.out.println("Value is NOT in the acceptable range!");
//        }

        // Solution 2

        boolean isInRange;
        int value;
        final int minValue = 10;
        final int maxValue = 25;
        do {
            System.out.print("Enter a number: ");

            // nextLine() says wait until reads "\n" off the string
            String input = console.nextLine();

            // convert string to int
            value = Integer.parseInt(input);
            isInRange = value >= minValue && value < maxValue;


            if(!isInRange) {
                System.out.printf("%s is NOT in the acceptable range of %s - %s!\n",
                        value, minValue, maxValue);
            }
        } while (!isInRange);
        System.out.printf("%s is in the acceptable range.", value);


    }
}
