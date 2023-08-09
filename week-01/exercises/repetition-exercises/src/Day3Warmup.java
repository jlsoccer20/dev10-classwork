import  java.util.Scanner;
import java.util.Random;
public class Day3Warmup {
    public static void main(String[] args) {

        Random rand = new Random();
        int numKnockKnock = rand.nextInt(6); // 0 to 5
        String jokeStart = "Knock Knock!\n";

        Scanner console = new Scanner(System.in);


        while (numKnockKnock > 0){
            System.out.printf("%s", jokeStart);

            String word = "";
            while (!word.equals("Who's there?")){
                System.out.print("Answer: ");
                word = console.nextLine();
            }

            System.out.println("\nBanana!\n");
            numKnockKnock--;
        }

        System.out.printf("%s", jokeStart);
        String word = "";
        while (!word.equals("Who's there?")){
            System.out.print("Answer: ");
            word = console.nextLine(); // calling for input
        }
        System.out.println("Orange");

        while (!word.equals("Orange who?")){
            System.out.print("Answer: ");
            word = console.nextLine(); //overwrites the value stored in variable "word"
        }
        System.out.println("Orange you glad I didn't say banana?");
    }
}
