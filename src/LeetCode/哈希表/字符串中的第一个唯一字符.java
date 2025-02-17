package LeetCode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        // 初始化一个哈希表用于统计字符出现次数
        Map<Character, Integer> charCount = new HashMap<>();
        // 第一次遍历字符串，统计每个字符的出现次数
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        // 第二次遍历字符串，找到第一个出现次数为 1 的字符的索引
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // 如果没有找到，返回 -1
        return -1;
    }
}
