public class Exercise07 {

    // 1. Create a method.
    public static boolean areInOrder(int first, int second, int third, int fourth){
        if (first < second && second < third && third < fourth){
            return true;
        } else{
            return false;
        }
    }
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(areInOrder(1,2,3,4)); //true
        System.out.println(areInOrder(2,10,3,1)); // false
    }
}
