package org.example.leetcode;

/**
 * @author Ivyevy
 * @description:
 */
public class oneToN {
    public static int[] printNumbers(int n) {
        int[] arr = new int[(int)(Math.pow(10, n) - 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
