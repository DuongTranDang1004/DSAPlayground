package Array;

import java.util.Arrays;

public class RemoveElement {

    // Method to remove all instances of val from nums and return the new length
    //Patterns:
    //using 2 pointer: 1 for val, 1 for values not equal to val (un-val)
    //loop through the array
    //then manipulating these 2 pointer so any un-val move to the front of the array
    public static int removeValElementAndReturnNewArrayLengthWithoutVal(int[] nums, int val) {
        int notValIndex = 0;
        for (int loopingIndex = 0; loopingIndex < nums.length; loopingIndex++) {
            if (nums[loopingIndex] != val) {
                nums[notValIndex] = nums[loopingIndex];
            }
            notValIndex++;
        }
        return notValIndex;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int[] expectedNums = {0, 1, 3, 0, 4}; // Expected result after removal

        int k = removeValElementAndReturnNewArrayLengthWithoutVal(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i] : "Element mismatch at index " + i;
        }

        System.out.println("Modified array length: " + k);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }

    public class RemoveElementSolution {

        // Method to remove all instances of val from nums and return the new length
        //Patterns:
        //using 2 pointer: 1 for val, 1 for values not equal to val (un-val)
        //loop through the array
        //then manipulating these 2 pointer so any un-val move to the front of the array
        public static int removeValElementAndReturnNewArrayLengthWithoutVal(int[] nums, int val) {

            int notValIndex = 0; //pointer for notVal elements
            for (int currentLoopingElementIndex = 0; currentLoopingElementIndex < nums.length; currentLoopingElementIndex++) {
                //check if the currentLoopingElement is not equal to val
                if (nums[currentLoopingElementIndex] != val) {
                    // copy the current valid element to the notValIndex position to move notValIndex to the front (as we start looping the array from the left front)
                    nums[notValIndex] = nums[currentLoopingElementIndex]; //why the order of this copying variable does matter ?
                    // then increment notValIndex pointer by 1
                    notValIndex++;
                }
            }
            return notValIndex;// Return new length of the array without the element 'val' = the last notValIndex
        }
    }
}
