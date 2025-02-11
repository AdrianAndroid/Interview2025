package LeetCode.排序;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length  <= 1) {
            return;
        }
        // 找出数组中的最大值
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // 定义计数数组，长度为最大值 + 1
        int[] count = new int[max + 1];

        // 统计每个元素出现的次数
        for (int num : arr) {
            count[num]++;
        }

        // 遍历计数数组，将元素按顺序放回原数组
        int index = 0;
        for (int i = 0; i < count.length;  i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println(" 排序前:");
        for (int num : arr) {
            System.out.print(num  + " ");
        }
        // 调用计数排序方法
        countingSort(arr);
        System.out.println("\n 排序后:");
        for (int num : arr) {
            System.out.print(num  + " ");
        }
    }
}
