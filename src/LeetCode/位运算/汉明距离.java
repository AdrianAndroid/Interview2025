package LeetCode.位运算;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        // Step 1: XOR the two numbers to find differing bits
        int xor = x ^ y;
        
        // Step 2: Count the number of 1s in the XOR result
        int distance = 0;
        while (xor != 0) {
            // Increment distance for each 1 found
            distance += xor & 1;
            // Shift right to check the next bit
            xor >>= 1;
        }
        
        return distance;
    }
}