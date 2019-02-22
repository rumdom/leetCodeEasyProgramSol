import java.util.Arrays;

public class SingleNumber {
    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * * Note:
     * * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * @param args Solution 1: Bit Manipulation - Using XOR
     *             <p>
     *             If we take XOR of zero and some bit, it will return that bit
     *             a ^ 0 = a
     *             <p>
     *             If we take XOR of two same bits, it will return 0
     *             a ^ a = 0
     *             <p>
     *             XOR operator is commutative
     *             a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     *             <p>
     *             So we can XOR all bits together to find the unique number.
     */
    public static void main(String[] args) {
        int[] intArray = new int[]{0, 4, 4, 4, 1, 2, 1, 2};//0,0,1, 1, 3, 3, 4, 5, 2, 2, 5, 7, 4,5};
        SingleNumber main = new SingleNumber ( );
        int x = main.getNonDuplicateValue ( intArray );
        int y = main.singleNumber ( intArray );
        System.out.println ( "x:" + x + " y :" + y );
    }

    //This code works as per question working only for twice cases . the XOR
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;// a ^ 0 = a
        }
        return result;
    }

    //This code works for inputs all the repetition more than twice as well
    //MyCode
    public int getNonDuplicateValue(int[] nums) {
        int index = 0;
        int count = -1;
        int attemps = 0;
        while (index < nums.length) {
            count = index;
            attemps = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[index] == nums[i]) {
                    if (attemps >= 1) {
                        count = -1;
                        break;
                    } else {
                        attemps++;
                    }
                }
            }
            index++;
            if (count != -1) {
                break;
            }
        }
        System.out.println ( Arrays.toString ( nums ) );
        return nums[count];
    }
}
