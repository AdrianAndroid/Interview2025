package LeetCode.双指针;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Initialize the pointer for the next position to place a non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place the non-val element at the next position
                k++; // Move the pointer to the next position
            }
        }
        return k; // Return the number of elements that are not equal to val
    }
}
