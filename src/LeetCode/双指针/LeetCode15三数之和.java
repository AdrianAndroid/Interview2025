package LeetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15三数之和 {
    /**
     * Finds all unique triplets in the array which gives the sum of zero.
     *
     * @param nums The input array of integers.
     * @return A list of lists containing unique triplets that sum to zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Initialize the result list to store the triplets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array in ascending order to simplify the process of finding triplets
        Arrays.sort(nums);

        // Iterate through the array, considering each element as a potential first element of a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Initialize two pointers, one at the next element and one at the end of the array
            int left = i + 1;
            int right = nums.length - 1;
            // Calculate the target sum for the other two numbers
            int target = -nums[i];

            // Use two-pointer approach to find the other two numbers that sum up to the target
            while (left < right) {
                // Calculate the sum of the two numbers pointed by the left and right pointers
                int sum = nums[left] + nums[right];

                // If the sum is equal to the target, we found a triplet
                if (sum == target) {
                    // Add the triplet to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // Move the pointers to the next unique numbers
                    left++;
                    right--;
                }
                // If the sum is less than the target, move the left pointer to the right to increase the sum
                else if (sum < target) {
                    left++;
                }
                // If the sum is greater than the target, move the right pointer to the left to decrease the sum
                else {
                    right--;
                }
            }
        }
        // Return the list of triplets
        return result;
    }

}
