package Algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6, 1, 3, 5, 9, 4, 2, 8};
        System.out.println ( Arrays.toString ( quickSort ( array, 0, array.length - 1 ) ) );
    }

    private static int[] quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        int pivot = array[(left + right) / 2];
        int index = positionPivotElement ( array, left, right, pivot );
        quickSort ( array, left, index - 1 );
        quickSort ( array, index, right );

        return array;
    }

    private static int positionPivotElement(int[] array, int left, int right, int pivot) {

        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swapElements ( array, left, right );
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swapElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
