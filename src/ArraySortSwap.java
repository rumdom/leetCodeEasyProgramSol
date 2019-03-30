import java.util.ArrayList;
import java.util.List;

public class ArraySortSwap {
   /** Given a sorted array nums, remove the duplicates in-place such that each element appear
    * only once and return the new length.
    Do not allocate extra space for another array,
    you must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.
    **/
    public static void main(String[] args) {
        int[] intArray = new int[] {0,0,1,2,3,3,4,5};
        ArraySortSwap main=new ArraySortSwap ();
        int x= main.removeDuplicates ( intArray );
        System.out.println("x:"+x);
    }
    public  int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {// checking if they are same
                nums[index+1] = nums[i];//swap to previous value
                index++;
            }
        }
        return index+1;
    }
}
