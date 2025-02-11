package LeetCode.双指针;

public class 反转字符串 {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        String cleanString = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Check if the clean string is a palindrome
        int left = 0;
        int right = cleanString.length() - 1;
        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        反转字符串 solution = new 反转字符串();
        boolean result = solution.isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);
    }
}