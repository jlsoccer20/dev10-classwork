import java.util.Random;
import java.util.Scanner;
class RepetitionRandom {
    public static void main(String[] args) {

        Random rand = new Random();
        int a = 1;
        int b = 2;
        int c = 3;

        while (a < 50 || b%2 == 0 && c%3 !=0){

            System.out.printf("%s,%s,%s%n", a, b, c);

            a = rand.nextInt(100);
            b = rand.nextInt(100);
            c = rand.nextInt(100);
        }

        Scanner console = new Scanner(System.in);
        String word = "";

        while (!word.equals("magic")){
            System.out.print("Enter the \"magic\" word: ");
            word = console.nextLine();
        }
        System.out.println("You got it!");

        // do/while Loop
        do {
            System.out.println("prints once");
        } while (false);

        do {
            System.out.println("repeats forever");
        } while (true);



    }
}
