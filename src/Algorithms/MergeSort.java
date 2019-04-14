package Algorithms;

import java.util.Arrays;

/**
 * Merge sort is always done recursively .
 * ref https://youtu.be/KF2j-9iSf4Q
 */

class MergeSort {

    public static void main(String[] args) {
        int[] array = {4, 1, 5, 3, 2, 8, 7, 0};
        System.out.println ( Arrays.toString ( mergeSort ( array, new int[array.length], 0, array.length - 1 ) ) );
        //mergeSort ( array, new int[array.length], 0, array.length - 1 );
    }

    private static int[] mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return array;
            //return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort ( array, temp, leftStart, mid );
        mergeSort ( array, temp, mid + 1, rightEnd );
        mergeHalves ( array, temp, leftStart, rightEnd );
        return array;
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy ( array, left, temp, index, leftEnd - left + 1 );
        System.arraycopy ( array, right, temp, index, rightEnd - right + 1 );
        System.arraycopy ( temp, leftStart, array, leftStart, size );
    }
}
