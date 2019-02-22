import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        /**Given an array, rotate the array to the right by k steps, where k is non-negative.

         Example 1:

         Input: [1,2,3,4,5,6,7] and k = 3
         Output: [5,6,7,1,2,3,4]
         Explanation:
         rotate 1 steps to the right: [7,1,2,3,4,5,6]
         rotate 2 steps to the right: [6,7,1,2,3,4,5]
         rotate 3 steps to the right: [5,6,7,1,2,3,4]
         **/


        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int turns = 3;//number of rotations
        RotateArray main = new RotateArray ( );
        // main.getRotatedArray ( intArray, 2);


        main.reverse ( intArray, 0, intArray.length - 1 );    // [1, 2, 3, 4, a, b] --> [b, a, 4, 3, 2, 1]  Reverse entire array
        main.reverse ( intArray, 0, turns - 1 );            // [b, a, 4, 3, 2, 1] --> [a, b, 4, 3, 2, 1]  Reverse first 'k' elements
        main.reverse ( intArray, turns, intArray.length - 1 );    // [a, b, 4, 3, 2, 1] --> [a, b, 1, 2, 3, 4]  Reverse remaining 'n - k' elements
    }


    //Not my LOGIC
    private void reverse(int[] A, int start, int end) {
        while (start < end) // when both ends on same pointer or exceeds each other it exists.
        {
            int temp = A[start];// store start in temp
            A[start] = A[end]; // swap start with end
            start++; // increase start
            A[end] = temp;// swap end to start value
            end--;// decrease end
        }
        System.out.print ( Arrays.toString ( A ) );
    }

    //MyCode
    public void getRotatedArray(int[] nums, int turns) {
        if (turns > 0) {//number of turns not in negetive
            int count = 0;
            int len = nums.length;
            while (count < turns) { // to check the count reached 3 rotations
                int last = nums[len - 1];// hold the last value in the last variable
                int m = len - 2;//holding last -1 value
                for (int i = len - 1; i >= 0 & m >= 0; i--) {// starting the i with last value
                    nums[i] = nums[m];// swap last-1 to last value (swap all values from left to right direction)
                    m--;
                }
                nums[0] = last; // after everything swapped add the last value to first
                count++;// each rotation increment
            }
        }

        System.out.print ( Arrays.toString ( nums ) );

    }
}
