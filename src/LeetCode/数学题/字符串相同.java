package LeetCode.数学题;

public class 字符串相同 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        // 初始化结果数组
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算当前位的乘积
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 计算乘积在结果数组中的位置
                int p1 = i + j;
                int p2 = i + j + 1;
                // 加上之前的进位
                int total = mul + result[p2];
                // 更新结果数组
                result[p2] = total % 10;
                result[p1] += total / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 处理前导零
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
