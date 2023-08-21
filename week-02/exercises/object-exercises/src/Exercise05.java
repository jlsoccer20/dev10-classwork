import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);

        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        for (int i = 0; i <= 4; i++){ //
            musicians[i] = new Musician();
            System.out.printf("Who is your %sth favorite musician? ", i+1);
            musicians[i].setName(console.nextLine());
            //System.out.printf("Musician %s is %s.%n", i, musicians[i].getName());

        }
        System.out.println("Top 5 musicians are: ");

        for(Musician musician : musicians){
            System.out.printf("%s.%n", musician.getName());
        }
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)

        // 2. Use a second loop to print details about each musician.
    }
}
