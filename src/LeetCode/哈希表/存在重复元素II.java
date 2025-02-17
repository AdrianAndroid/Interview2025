package LeetCode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndex.containsKey(nums[i]) && i - numIndex.get(nums[i]) <= k) {
                return true;
            }
            numIndex.put(nums[i], i);
        }
        return false;
    }
}
