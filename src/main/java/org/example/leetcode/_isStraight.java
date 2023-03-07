package org.example.leetcode;

import java.util.Arrays;

/**
 * @author Ivyevy
 * @description:
 */
public class _isStraight {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[14];
        int begin = 0;
        int count = 0;
        for (int num : nums) {
            arr[num]++;
        }
        for (int num : nums) {
            if (num != 0) {
                begin = num;
                break;
            }
        }
        for (int i = begin; i <= nums[4]; i++) {
            if (arr[i] >= 2) {
                return false;
            }
            if (arr[i] == 0) {
                count++;
            }
        }
        if (count == arr[0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 2, 5};
        System.out.println(isStraight(arr));
    }
}
