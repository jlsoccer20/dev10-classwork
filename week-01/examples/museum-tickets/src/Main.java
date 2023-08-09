import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Museum Admission
//      Build an app that determines the total price for a group
//      of people going to science museum

        // Seniors 65 and over are $15.58
        // Children 3 and under free $0

        // ### Workflow
        // Get name for group
        // Number of people in group
        // For each person in the group, get age and therefore their price
        // display total price of group

        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to the Science Museum!");

        // print so can do inline
        System.out.print("What is your name? ");

        // capture name as input
        String name = console.nextLine();

        System.out.printf("Your name is %s.", name);

        System.out.println("\nHow many people are in your group? ");

        // parseInt wants a String
        int groupSize = Integer.parseInt(console.nextLine());

        System.out.printf("There are %s people in your group.", groupSize);

        double total = 0;

        // final = cannot change any variable values
        final double priceYouthSenior = 15.50;
        final double priceAdult = 25.00;
        final double priceBaby = 0;

        for (int index = 0; index < groupSize; index++) {
            System.out.printf("What is the age of group member %s? ", index + 1);
            int age = Integer.parseInt(console.nextLine());
            System.out.printf("Group member %s is %s years old. \n", index + 1, age);

            if (age <= 3){
                total += priceBaby;
                System.out.println("Your group member is free!");
                System.out.printf("Subtotal is: $%.2f.\n", total);

            } else if (age <= 14 || age >= 65) {

                total += priceYouthSenior;
                System.out.printf("Ticket price for group member %s is $%.2f.\n", index+1, priceYouthSenior);
                System.out.printf("Subtotal is: $%.2f.\n", total);
            } else {
                total += priceAdult;
                System.out.printf("Ticket price for group member %s is $%.2f.\n", index+1, priceAdult);
                System.out.printf("\nSubtotal is: $%.2f.\n", total);
            }

        }
        System.out.printf("Thank you, %s! Total price for your group is: $%.2f\n", name, total);
    }
}