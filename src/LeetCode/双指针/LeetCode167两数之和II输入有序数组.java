package LeetCode.双指针;

/**
 * 两数之和II输入有序数组
 */
public class LeetCode167两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // This line should never be reached since there is exactly one solution
        return new int[]{-1, -1};
    }
}
