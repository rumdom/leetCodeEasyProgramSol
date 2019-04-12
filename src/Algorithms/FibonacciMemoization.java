package Algorithms;

import java.util.HashMap;

public class FibonacciMemoization {

    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<> ( );
        System.out.println ( fib ( 7, memo ) );
        System.out.println ( fib ( 7 ) );
    }

    private static int fib(int n, HashMap<Integer, Integer> memo) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo.containsKey ( n )) {
            return memo.get ( n );
        }
        memo.put ( n, fib ( n - 1, memo ) + fib ( n - 2, memo ) );
        return memo.get ( n );
    }

    //performant fibonacci
    private static int fib(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
