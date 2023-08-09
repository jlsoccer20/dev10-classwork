import  java.util.Scanner;
import java.util.Random;
public class Day3Warmup {
    public static void main(String[] args) {

        Random rand = new Random();
        int numKnockKnock = rand.nextInt(11); // 0 to 10
        String jokeStart = "Knock Knock!";

        Scanner console = new Scanner(System.in);
        String word = "";

        while (numKnockKnock > 0){
            System.out.printf("%s", jokeStart);

            while (!word.equals("Who's there?")){
                System.out.print("Answer: ");
                word = console.nextLine();
            }

            System.out.println("\nBanana!");
            numKnockKnock--;
        }

    }
}
