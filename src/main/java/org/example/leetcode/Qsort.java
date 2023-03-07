package org.example.leetcode;

/**
 * @author Ivyevy
 * @description:
 */
public class Qsort {
    // 返回每次枢纽应该在的位置
    public static int pivot(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int piv = pivot(arr, low, high);
            // 排序枢纽左边的
            QuickSort(arr, low, piv - 1);
            // 排序枢纽右边的
            QuickSort(arr, piv + 1, high);
        }
    }

    public static int[] QuickSelect(int[] arr, int low, int high, int k) {
        if (k == 0) {
            return new int[0];
        }
        int piv = pivot(arr, low, high);
        int numK = piv - low + 1;
        if (numK == k) {
            return arr;
        } else if (numK < k) {
            QuickSelect(arr, piv + 1, high, k - numK);
        } else {
            QuickSelect(arr, low, piv - 1, k);
        }
        return new int[0];
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        QuickSelect(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] res = getLeastNumbers(arr, 8);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
