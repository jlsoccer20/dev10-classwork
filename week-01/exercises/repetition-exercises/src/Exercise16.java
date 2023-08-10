public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **

        final int ROWS = 8; // constants
        final int COLUMNS = 5; // constants
        String border = "*";
        String inner = "#";

        for(int row = 0; row < ROWS; row++){

                for (int col = 0; col < COLUMNS; col++) {

                    // row == 0 is going to draw a border symbol (top line)
                    // col == 0 is left edge, draw border (left side)
                    //
                    if (col == 0 || col == COLUMNS -1 || row == 0 || row == ROWS - 1) {
                        System.out.print(border);
                    } else {
                        System.out.print(inner);
                    }
                }
            System.out.println();
        }
    }
}
