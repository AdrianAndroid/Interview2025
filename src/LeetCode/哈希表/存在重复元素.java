package LeetCode.哈希表;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
