public class Exercise13 {

    public static void main(String[] args) {

        int purchaseQuantity = 2;
        boolean hasCoupon = false;

        // 1. Declare a boolean variable hasDiscount.
        boolean hasDiscount;

        // 2. Use an expression with comparison operators to assign its value.
        //hasDiscount = 1; // ??

        // hasDiscount is true if purchaseQuantity is greater than or equal to 6 OR hasCoupon is true.

        hasDiscount = purchaseQuantity >= 6 || hasCoupon = true;

        // 3. Print the result.
        System.out.println(hasDiscount);

        // 4. Change the values of purchaseQuantity and hasCoupon to get both true and false results for hasDiscount
        // in different ways.
    }
}
