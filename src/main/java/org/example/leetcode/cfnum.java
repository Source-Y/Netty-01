package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivyevy
 * @description:
 */
class cfnum {
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] == -1) {
                return nums[i];
            }else {
                arr[nums[i]] = -1;
            }
        }
        return 0;
    }
}
