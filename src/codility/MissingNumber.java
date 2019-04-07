package codility;

import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] A = {2};
        // solution ( A );
        System.out.println ( solution ( A ) );
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        if (A.length == 1) {
            if (A[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        boolean isFalse = false;
        Arrays.sort ( A );
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > 0) {
                if (A[i] > 1 && !isFalse) {
                    return 1;
                } else {
                    isFalse = true;
                    if (A[i + 1] - A[i] > 1) {
                        return A[i] + 1;
                    }
                    if (i + 1 == A.length - 1) {
                        return A[i + 1] + 1;
                    }
                }
            }
        }
        return 1;
        // write your code in Java SE 8
    }
}
