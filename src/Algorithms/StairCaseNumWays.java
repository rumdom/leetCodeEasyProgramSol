package Algorithms;

public class StairCaseNumWays {
    public static void main(String[] args) {
        int[] allowed_steps = {1, 3, 5};
        //System.out.println ( num_ways1 ( 4 ) );
        //System.out.println ( num_ways2 ( 4 ) );
        //  System.out.println ( num_ways ( 4, allowed_steps ) );
        //System.out.println ( num_ways3 ( 4 ) );
        System.out.println ( num_ways4 ( 4 ) );
    }

    //recursive fibonacci
    private static int num_ways1(int total_steps) {
        if (total_steps == 0 || total_steps == 1) {
            return 1;
        }
        return num_ways1 ( total_steps - 1 ) + num_ways1 ( total_steps - 2 );
    }

    //performant fibonacci
    private static int num_ways2(int total_steps) {
        int[] nums = new int[total_steps + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= total_steps; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[total_steps];
    }


    private static int num_ways3(int total_steps) {
        if (total_steps < 0) {
            return 0;
        }
        if (total_steps == 0 || total_steps == 1) {
            return 1;
        }
        return num_ways3 ( total_steps - 1 ) + num_ways3 ( total_steps - 3 ) + num_ways3 ( total_steps - 5 );
    }
    private static int num_ways4(int n) {
        int[] allowed_steps = {1, 3, 5};
        int[] nums = new int[n + 1];
        nums[0] = 1;
        int total = 0;
        for (int i = 1; i <=n; i++) {
            total = 0;
            for (int j = 0; j < allowed_steps.length; j++) {
                if (i - allowed_steps[j] >= 0) {
                    total += nums[i - allowed_steps[j]];
                }
            }
            nums[i] = total;
        }
        return nums[n];
    }
}
