public class Exercise15 {

    public static void main(String[] args) {

        int value = 115;

        // 1. Declare a boolean variable inRange.
        boolean inRange = (value >= 10 && value <= 20) || (value >= 110 && value <= 120);
        // 2. When value is between 10 and 20 OR value is between 110 and 120, inRange is true. Otherwise, it's false.
        // 3. Build an expression using value to set inRange.

        // 4. Print the result.
        System.out.println("Exercise 15: value is between 10 and 20 or 110 and 120: " + inRange);

        // 5. Change value to test different cases:
        // - less than 10
        // - between 10 and 20
        // - between 21 and 109
        // - between 110 and 120
        // - greater than 120
    }
}
