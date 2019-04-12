import java.util.HashSet;

public class tomtom2 {

    public static void main(String[] args) {
        int[] array = {6, 1, 4, 6, 3, 2, 7, 4};
        System.out.println ( maxConsecutiveSum ( array, 4, 3 ) );

    }

    private static int maxConsecutiveSum(int[] array, int k, int l) {
        if (array == null) {
            return -1;
        }
        int maxLength = k + l;
        int arrayLength = array.length;
        int sum = 0;
        if (maxLength > arrayLength) {
            return -1;
        } else if (maxLength == arrayLength) {
            for (int i = 0; i < arrayLength; i++) {
                sum = sum + array[i];
            }
        } else {
            HashSet<Integer> possibleIndices = new HashSet<> ( );
            sum = possibleCombinations ( array, k, l, possibleIndices );

        }
        return sum;
    }

    private static int possibleCombinations(int[] trees, int aliceTrees, int bobTrees, HashSet<Integer> possibleIndices) {

        int maxSum = 0;
        for (int i = 0; i < trees.length - aliceTrees; i++) {
            possibleIndices.clear ( );
            int temp = 0;
            for (int j = i; j < aliceTrees + i; j++) {
                temp = temp + trees[j];
                possibleIndices.add ( j );
            }
            temp += getMaxSumOfL ( trees, bobTrees, possibleIndices );
            if (maxSum < temp) {
                maxSum = temp;
            }
        }

        return maxSum;
    }

    private static int getMaxSumOfL(int[] trees, int bobTrees, HashSet<Integer> possibleIndices) {
        int sum = 0;

        for (int i = 0; i < trees.length - bobTrees; i++) {
            int temp = 0;
            for (int j = i; j < bobTrees + i; j++) {
                temp = temp + trees[j];
            }
            if (temp > sum) {
                if (!checkOverlap ( i, bobTrees, possibleIndices )) {
                    sum = temp;
                }
            }
        }
        return sum;
    }

    private static boolean checkOverlap(int currentIndex, int bobTrees, HashSet<Integer> possibleIndices) {
        boolean contains = false;
        for (int i = 0; i < bobTrees; i++) {
            if (possibleIndices.contains ( i + currentIndex )) {
                contains = true;
                break;
            }
        }
        return contains;
    }

}
