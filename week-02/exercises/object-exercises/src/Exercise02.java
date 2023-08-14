public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        // 2. Uncomment the line below and insure that it compiles and runs.
        System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        Musician Lennon = new Musician("John", 100);
        Musician Park = new Musician("Linkin", 80);

        // 4. Print each musicians' name and rating on a single line.
        System.out.printf("Musician %s has rating %s%n", Lennon.getName(), Lennon.getRating());
        System.out.printf("Musician %s has rating %s", Park.getName(), Park.getRating());

    }
}
