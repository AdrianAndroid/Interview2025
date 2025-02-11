package LeetCode.排序;

public class InsertionSort {
    /**
     * 插入排序算法实现
     *
     * @param arr 待排序的整数数组
     */
    public static void insertSort(int[] arr) {
        // 获取数组的长度
        int n = arr.length;
        // 从第二个元素开始遍历数组
        for (int i = 1; i < n; i++) {
            // 将当前元素存储在key中，这个元素将被插入到已排序部分的正确位置
            int key = arr[i];
            // 初始化j为当前元素的前一个位置
            int j = i - 1;
            // 将key大的元素向后移动
            // 当j大于等于0且当前元素小于arr[j]时，将arr[j]向后移动一位
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            // 将key插入到正确的位置
            arr[j+1] = key;
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertSort(arr);
        System.out.println("排序后的数组:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
