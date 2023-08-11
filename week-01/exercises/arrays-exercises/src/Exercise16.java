import java.util.Random;

public class Exercise16 {

    public static void main(String[] args) {
        // MERGE
        int[] one = makeRandomAscendingArray();
        int[] two = makeRandomAscendingArray();

        // makeRandomAscendingArray creates a random array with a capacity between 50 and 150.
        // Its elements are guaranteed to be sorted ascending.
        // 1. Create a new int[] with capacity for all elements from `one` and `two`.
        // 2. "Merge" elements from `one` and `two` into the new array so that its values are sorted.
        int[] result = new int[one.length + two.length];

         /* Pseudocode:
         Create an integer index for `one`, `two`, and the result array, all starting at 0.
         Loop resultIndex from 0 to result.length - 1:
           if one[oneIndex] is less than two[twoIndex], add it to the result and increment oneIndex.
           if two[twoIndex] is less than one[oneIndex], add it to the result and increment twoIndex.
           determine how to settle ties
           if oneIndex >= one.length, there are no `one` elements remaining so use elements from two
           if twoIndex >= two.length, there are no `two` elements remaining so use elements from one
          */
        int oneIndex = 0;
        int twoIndex = 0;
        for (int i = 0; i < result.length; i++){
            if (oneIndex >= one.length){
                result[i] = two[twoIndex];
                twoIndex++;
            } else if (twoIndex >= two.length){
                result[i] = one[oneIndex];
                oneIndex++;
            } else if (one[oneIndex] <= two[twoIndex]){
                result[i] = one[oneIndex];
                oneIndex++;
            } else if (two[twoIndex] < one[oneIndex]){
                result[i] = two[twoIndex];
                twoIndex++;
            }
        }
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }


    }

    public static int[] makeRandomAscendingArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        int current = random.nextInt(11);
        for (int i = 0; i < result.length; i++) {
            result[i] = current;
            current += random.nextInt(4);
        }
        return result;
    }
}
