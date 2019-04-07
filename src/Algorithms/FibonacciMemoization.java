package Algorithms;

import java.util.HashMap;

public class FibonacciMemoization {

    public static void main(String[] args) {
        HashMap<Integer, Integer> memo = new HashMap<> ( );
        System.out.println ( fib ( 7, memo ) );
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

}
