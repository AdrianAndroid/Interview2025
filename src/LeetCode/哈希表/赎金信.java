package LeetCode.哈希表;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an array to count the occurrences of each letter in the magazine
        int[] charCount = new int[26];
        // Count the occurrences of each letter in the magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check if we can construct the ransom note using the letters from the magazine
        for (char c : ransomNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        赎金信 solution = new 赎金信();
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(solution.canConstruct(ransomNote, magazine)); // Output: false
    }
}