package org.example.leetcode;

/**
 * @author Ivyevy
 * @description:
 */
public class Search_i {
    static int count = 0;

    public static void partition(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                count++;
                // 必须递归下去
                partition(nums, left, middle - 1, target);
                partition(nums, middle + 1 ,right, target);
            } else if (nums[middle] > target) {
                partition(nums, left, middle - 1, target);
            } else {
                partition(nums, middle + 1 ,right, target);
            }
        }
    }
    public static int search(int[] nums, int target) {
        partition(nums, 0, nums.length - 1, target);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};

        int count = search(arr, 8);
        System.out.println(count);
    }
}
