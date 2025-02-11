package LeetCode.位运算;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println(5 ^ 5);
        System.out.println(5 ^ 6);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    // 10
    // 10
    // 00 -
    // 01
    // 0
}
