package org.example.leetcode;

/**
 * @author Ivyevy
 * @description:
 */
public class sumS {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        res(0, nums.length - 1, nums, res, target);
        return res;
    }
public static int[] twoSum1(int[] nums, int target) {
    int[] res = new int[2];
    int i = 0, j = nums.length - 1;
    while (i < j) {
        if (nums[i] + nums[j] == target) {
            res[0] = nums[i];
            res[1] = nums[j];
            return res;
        } else if (nums[i] + nums[j] < target) {
            i++;
        } else {
            j--;
        }
    }
    return res;
}

    public static void res(int i, int j, int[] nums, int[] res, int target) {
        if (i == j) {
            return ;
        }
        if (nums[i] + nums[j] == target) {
            res[0] = nums[i];
            res[1] = nums[j];
        } else if (nums[i] + nums[j] < target) {
            res(i + 1, j, nums, res, target);
        } else {
            res(i, j - 1, nums, res, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] ints = twoSum(arr, 9);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
