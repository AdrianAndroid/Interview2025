package LeetCode.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    // Mapping of digits to letters
    private static final String[] PHONE_MAP = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String digits, int index) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = PHONE_MAP[digit];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(result, path, digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
