package LeetCode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 四数相加2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null || nums2 == null || nums3 == null || nums4 == null ||
                nums1.length == 0 || nums2.length == 0 || nums3.length == 0 || nums4.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int target = - (num3 + num4);
                if (sumMap.containsKey(target)) {
                    count += sumMap.get(target);
                }
            }
        }

        return count;
    }
}
