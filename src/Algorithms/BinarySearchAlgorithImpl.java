package Algorithms;

import java.util.Arrays;

public class BinarySearchAlgorithImpl {

    public static void main(String[] args) {
        int[] array = {1, 3, 87, 5, 75, 7, 6, 3, 98, 67, 9};
        System.out.println ( binarySEarchRecursive ( array, 9 ) );
    }

    private static boolean binarySEarchRecursive(int[] array, int searchElement) {
        Arrays.sort ( array );
        // return binarySearchRecursive ( array, 0, array.length - 1, searchElement );
        return binarySearchIterator ( array, searchElement );
    }

    private static boolean binarySearchRecursive(int[] array, int leftIndex, int rightIndex, int searchElement) {
        if (leftIndex > rightIndex) {
            return false;
        }
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (array[middleIndex] == searchElement)
            return true;
        else if (array[middleIndex] > searchElement) {
            return binarySearchRecursive ( array, 0, middleIndex - 1, searchElement );
        } else {
            return binarySearchRecursive ( array, middleIndex + 1, rightIndex, searchElement );
        }
    }

    private static boolean binarySearchIterator(int[] array, int searchElement) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middleIndex = (leftIndex + rightIndex) / 2;
        while (leftIndex <= rightIndex) {
            int x = array[middleIndex];
            if (array[middleIndex] == searchElement)
                return true;
            else if (array[middleIndex] > searchElement) {
                rightIndex = middleIndex - 1;
                middleIndex = getMiddleIndexe ( leftIndex, rightIndex );
            } else {
                leftIndex = middleIndex + 1;
                middleIndex = getMiddleIndexe ( leftIndex, rightIndex );
            }
        }
        return false;
    }

    private static int getMiddleIndexe(int start, int end) {
        int mid = (start + end) / 2;
        return mid;
    }


}

