import java.util.Scanner;
public class RepetitionLessonExample {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input;
        boolean isValid = false;

        // 1. the `do/while` approach doesn't repeat code
        // ==============================================
        do {
            System.out.println("1. Red");
            System.out.println("2. Blue");
            System.out.println("3. Yellow");
            System.out.print("Choose your favorite primary color [1-3]: ");
            input = console.nextLine();
            isValid = input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '3';
            if (!isValid) {
                System.out.printf("\"%s\" is not a valid number between 1 and 3.%n", input);
            }
        } while (!isValid);

        isValid = false;

        // 2. the `while` approach repeats code
        // ====================================
        // it must prompt the user before its condition
        System.out.println("1. Red");
        System.out.println("2. Blue");
        System.out.println("3. Yellow");
        System.out.print("Choose your favorite primary color [1-3]: ");
        input = console.nextLine();
        isValid = input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '3';
        if (!isValid) {
            System.out.printf("\"%s\" is not a valid number between 1 and 3.%n", input);
        }

        while (!isValid) {
            // and prompt again inside the code block
            System.out.println("1. Red");
            System.out.println("2. Blue");
            System.out.println("3. Yellow");
            System.out.print("Choose your favorite primary color [1-3]: ");
            input = console.nextLine();
            isValid = input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '3';
            if (!isValid) {
                System.out.printf("\"%s\" is not a valid number between 1 and 3.%n", input);
            }
        }

    }
}
