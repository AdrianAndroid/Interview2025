package LeetCode.位运算;

/**
 * https://leetcode.cn/problems/missing-number/
 0  0 
 1  0001 
 2  0010 
 3  0011 
 4  0100 
 5  0101 
 6  0110 
 7  0111 
 8  1000 
 9  1001 
 */
public class 丢失的数字 {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        丢失的数字 solution = new 丢失的数字();
        int result = solution.missingNumber(nums);
        System.out.println(result);
    }
    public int missingNumber(int[] nums) {
        // 获取数组的长度，数组长度为 n，代表包含 [0, n] 范围内的 n 个数
        int n = nums.length;
        // 初始化异或结果为 0
        int xor = 0;
        // 先对 [0, n] 范围内的数字进行异或
        for (int i = 0; i <= n; i++) {
            xor ^= i;
            // System.out.println("xor : "+xor+" : "+String.format("%4s", Integer.toBinaryString(xor)).replace(' ','0'));
        }
        // 再对数组中的元素进行异或
        for (int num : nums) {
            xor ^= num;
        }
        // 返回最终的异或结果，即为缺失的数字
        return xor;
    }
}
