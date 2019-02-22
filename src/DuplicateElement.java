public class DuplicateElement {
    /**
     * Given an array of integers, find if the array contains any duplicates.
     * <p>
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: true
     **/

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 5, 9};
        DuplicateElement main = new DuplicateElement ( );
        boolean x = main.containsDuplicates ( intArray );
        System.out.println ( "x:" + x );
    }

    public boolean containsDuplicates(int[] nums) {
        int index = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] == nums[i]) {// checking if they are same
                return true;
            }
            if (i == nums.length - 1) {
                index++;
                i=index+1;
            }
        }
        return false;
}


}
