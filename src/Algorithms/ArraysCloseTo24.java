package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * question is in the link below.
 * https://www.youtube.com/watch?v=GBuHSRDGZBY
 */
public class ArraysCloseTo24 {
    public static void main(String[] args) {
        int[] array1 = {7, 4, 1, 10};
        int[] array2 = {2, 3, 8, 7};
        closestToTarget ( 13, array1, array2 );
    }

    private static void closestToTarget(int target_value, int[] array1, int[] array2) {
        Stack<List<Integer>> possiblilities = new Stack<> ( );
        int current_loc = array2.length - 1;
        int sum_of_2Values = 0;
        int no_of_iteration = 0;
        int min_diff = -1, cur_diff = 0;
        //sorting the arrays
        Arrays.sort ( array1 );
        Arrays.sort ( array2 );
        for (int i = 0; i < array1.length; i++) {
            for (int j = current_loc; j >= 0; j--) {
                no_of_iteration++;
                sum_of_2Values = array1[i] + array2[j];
                cur_diff = Math.abs ( target_value - sum_of_2Values );
                if (min_diff < 0) {
                    min_diff = cur_diff;
                }
                if (sum_of_2Values == target_value) {
                    System.out.println ( array1[i] + " " + array2[j] );
                    return;

                }
                else if (sum_of_2Values < target_value) {
                    if (cur_diff <= min_diff) {
                        min_diff = cur_diff;
                        combinations_found ( array1[i], array2[j], possiblilities, min_diff );
                        break;
                    }
                } else {
                    current_loc--;
                    if (cur_diff <= min_diff) {
                        min_diff = cur_diff;
                        combinations_found ( array1[i], array2[j], possiblilities, min_diff );
                        continue;

                    }
                }
            }
        }
        System.out.println ( "counter" + no_of_iteration );
        extractOutput ( possiblilities );
    }

    private static void combinations_found(int e, int e1, Stack<List<Integer>> possiblilities, int diff) {
        List<Integer> nums = new ArrayList<> ( );
        nums.add ( e );
        nums.add ( e1 );
        possiblilities.push ( nums );
    }

    private static void extractOutput(Stack<List<Integer>> stack) {
        while (!stack.empty ( )) {
            System.out.println ( stack.pop ( ) );
        }
    }

}
