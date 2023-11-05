import java.util.*;

public class MergeSort {

    static void merge(int[] arr, int l, int m, int h) {
        int[] ans = new int[arr.length];
        int i = l, j = m, k = l;

        while (i <= m && j <= h) {
            if (arr[i] <= arr[j]) {
                ans[k] = arr[i];
                k++;
                i++;
            } else {
                ans[k] = arr[j];
                k++;
                j++;
            }
        }

        // Copy the remaining elements of the left subarray.
        while (i <= m) {
            ans[k] = arr[i];
            k++;
            i++;
        }

        // Copy the remaining elements of the right subarray.
        while (j <= h) {
            ans[k] = arr[j];
            k++;
            j++;
        }

        // Copy the sorted elements back to the original array.
        for (int k2 = l; k2 < h; k2++) {
            arr[k2] = ans[k2];
        }
    }

    static void mergeSort(int[] arr, int l, int h) {
        // Check if the subarray is already sorted.
        if (l < h) {
            int mid = l + (h - l) / 2;

            // Recursively sort the left and right subarrays.
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);

            // Merge the sorted subarrays.
            merge(arr, l, mid, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
