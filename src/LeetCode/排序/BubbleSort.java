package LeetCode.排序;

public class BubbleSort {

    /**
     * 冒泡排序算法实现
     *
     * @param arr 待排序的整数数组
     */
    public static void bubbleSort(int[] arr) {
        // 获取数组的长度
        int n = arr.length;
        // 用于标记是否发生了交换
        boolean swapped;
        // 外层循环控制排序趟数
        for (int i = 0; i < n - 1; i++) {
            // 初始化swapped为false，表示本轮没有发生交换
            swapped = false;
            // 内层循环控制每趟排序的比较次数
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果当前元素大于下一个元素，则交换它们的位置
                if (arr[j] > arr[j+1]) {
                    // 交换arr[j]和arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 标记发生了交换
                    swapped = true;
                }
            }
            // 如果本轮没有发生交换，说明数组已经有序，提前结束排序
            if (!swapped) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("排序后的数组:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
