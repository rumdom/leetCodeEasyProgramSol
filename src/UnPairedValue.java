import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * returns the value of the unpaired element.
 * the function should return 7, as explained in the example above.
 */
public class UnPairedValue {
    public static void main(String[] args) {
        int[] intArray = {1,1, 0, 2, 2, 3, 3, 0,9};

        System.out.println ( solution ( intArray ) );
    }


    public static int solution(int[] A) {
        // write your code in Java SE 8
        {
            List<Integer> x = IntStream.of ( A )      // returns IntStream
                    .boxed ( )
                    .collect ( Collectors.toList ( ) );
            Collections.sort ( x );
            //int val = -1;
            for (int i = 0; i < x.size ( ) - 1; i++) {
                if (x.get ( i ).equals ( x.get ( i + 1 ) )) {
                    i = i + 1;
                } else {
                    return x.get ( i );
                }
            }
            return x.get ( x.size ( ) - 1 );

        }
    }

}
