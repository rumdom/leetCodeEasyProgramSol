package codility;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 */
public class MissingElementInPermu {
    public static void main(String[] args) {
        int[] intArray = {2,4};

        System.out.println ( solution ( intArray ) );
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        List<Integer> x = IntStream.of ( A )      // returns IntStream
                .boxed ( )
                .collect ( Collectors.toList ( ) );
        Collections.sort ( x );
        int i = 0;
        while (i < x.size ( )) {
            if (x.get ( i ) != ++i) {
                return i;
            }
        }
        return x.get ( x.size ( ) - 1 ) + 1;

    }
}
