public class Exercise15 {

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public static void main(String[] args) {

        // 2. Instantiate your three favorite superheroes with appropriate powers.

        Hero scarletWitch = new Hero("Scarlet Witch", new Power[]{
                new Power("Red Magic"),
                new Power("Telekinesis")
        });

        Hero vision = new Hero("Vision", new Power[]{
                new Power("Flight"),
                new Power("Phasing"),
                new Power("Mass Increase")
        });

        Hero antMann = new Hero("Antmann", new Power[]{
                new Power("Shrink"),
                new Power("Herd ants")
        });

        // 3. Use the `toLine` method to print each hero's details to the console.
        System.out.println(scarletWitch.toLine());
        System.out.println(vision.toLine());
        System.out.println(antMann.toLine());

    }
}
