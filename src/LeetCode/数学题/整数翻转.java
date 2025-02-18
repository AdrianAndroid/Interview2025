package LeetCode.数学题;

public class 整数翻转 {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // 检查是否溢出
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            result = result * 10 + digit;
        }
        result *= sign;
        return result;
    }
}
