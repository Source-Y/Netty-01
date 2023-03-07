package org.example;

import org.example.leetcode.oneToN;

/**
 * @author Ivyevy
 * @description: ${description}
 */
public class Main {
    public static void main(String[] args) {

        int[] ints = oneToN.printNumbers(2);
        for (int i : ints) {
            System.out.println(i);
        }
    }
    static class oneToN {
        public static int[] printNumbers(int n) {
            int[] arr = new int[(int)(Math.pow(10, n) - 1)];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            return arr;
        }
    }
}