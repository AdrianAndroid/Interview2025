package LeetCode.排序;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * This method partitions the array into two parts: elements less than the pivot and elements greater than the pivot.
     * It returns the index of the pivot element after partitioning.
     *
     * @param arr The array to be partitioned.
     * @param low The starting index of the partition.
     * @param high The ending index of the partition.
     * @return The index of the pivot element after partitioning.
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the last element as the pivot
        int pivot = arr[high];
        // Index of the smaller element
        int i = low - 1;
        // Iterate through the array from low to high-1
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment the index of the smaller element
                i++;
                // Swap the current element with the element at the index of the smaller element
                swap(arr, i, j);
            }
        }
        // Swap the pivot element with the element at the index of the smaller element + 1
        swap(arr, i + 1, high);
        // Return the index of the pivot element after partitioning
        return i + 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
