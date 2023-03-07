package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivyevy
 * @description:
 */
public class _majorityElement {
//    public static int majorityElement(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int maxCount = -1, maxNum = 0;
//        Map<Integer, Integer> map = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                int count = map.get(nums[i]);
//                if (count > maxCount) {
//                    maxCount = count;
//                    maxNum = nums[i];
//                }
//                map.put(nums[i], count + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        return maxNum;
//    }
    public static int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 3, 4, 5, 6};
        System.out.println(majorityElement(arr));
    }
}
