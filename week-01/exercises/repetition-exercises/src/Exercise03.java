public class Exercise03 {

    public static void main(String[] args) {
        // 1. Write a loop to count backward from 23 to 17.
        int index = 23;

        while (index >= 17){
            System.out.println(index);
            index--; // index = index - 1
        }

        // Expected Output
        // 23
        // 22
        // 21
        // 20
        // 19
        // 18
        // 17
    }
}
