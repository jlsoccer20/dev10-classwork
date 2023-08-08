public class Exercise07 {

    public static void main(String[] args) {
        // 1. Calculate the number of offices in a 23 story building
        // where each floor has 15 "rows" and 8 "columns" of offices.

        int numOffices;
        int floor;
        int building;
        int rowsOfOffices = 15;
        int columnsOfOffices = 8;

        floor = rowsOfOffices * columnsOfOffices;

        building = 23 * floor;

        numOffices = building;

        // 2. Use whatever approach you think is best.
        // 3. Print the result.

        System.out.println(numOffices);
    }
}
