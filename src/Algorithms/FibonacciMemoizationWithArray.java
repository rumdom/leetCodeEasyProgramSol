package Algorithms;

public class FibonacciMemoizationWithArray {

    public static void main(String[] args) {
        int[] memoizedValues = new int[7];//the length of the array should be greater than the N
        System.out.println ( getFibonacci ( 6, memoizedValues ) );
        System.out.println ( getFibonacci ( 6 ) );
    }

    private static int getFibonacci(int N, int[] memoizedValues) {

        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (memoizedValues[N] != 0) {
            return memoizedValues[N];
        }
        memoizedValues[N] = getFibonacci ( N - 1, memoizedValues ) + getFibonacci ( N - 2, memoizedValues );

        return memoizedValues[N];
    }

    //performant fibonacci
    private static int getFibonacci(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
