import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] intArray = new int[]{4,9,5,7,7};
        int[] intArray1 = new int[]{9,4,9,8,7,7,4};
        int[] result = null;
        IntersectionOfTwoArrays main = new IntersectionOfTwoArrays ( );
        result = main.findDuplicates ( intArray, intArray1 );
        System.out.println ( "result:" + Arrays.toString ( result ) );
    }

    public int[] findDuplicates(int[] nums, int[] nums1) {
        int index = 0;
        int[] clone = nums1.clone ( );
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums[i] == nums1[j]) {// checking if they are same
                    nums1[j] = -1;
                    index++;
                    break;
                }
            }
        }
        int[] result = new int[index];
        int count = 0;
        int i;
        for (i = 0; i < nums1.length; i++) {
            if (nums1[i] == -1) {
                result[count] = clone[i];
                count++;
            }
        }
        return result;
    }


}
