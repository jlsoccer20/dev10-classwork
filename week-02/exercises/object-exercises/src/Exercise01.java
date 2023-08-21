public class Exercise01 {

    public static void main(String[] args) {

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());

        // 1. Find the Musician class in this project.
        // It is stored as a separate .java file in the same folder

        // 2. Read its constructor comments.

        // 3. Instantiate two more musicians and assign them to new variables.
        // 4. Print the musicians' names to the console.

        Musician beatles = new Musician("Paul McCartney",100);
        System.out.println(beatles.getName());

        Musician rollingStones = new Musician("Mick Jagger", 50);

        Musician grouper = new Musician("Grouper",10);

        System.out.println(rollingStones.getName());
        System.out.println(rollingStones.getClass());

    }
}
