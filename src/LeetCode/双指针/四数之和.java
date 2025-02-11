package LeetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array first

        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;
                long newTarget = (long) target - nums[i] - nums[j];

                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

}
