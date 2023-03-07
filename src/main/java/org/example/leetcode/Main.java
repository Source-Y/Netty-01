package org.example.leetcode;

import java.util.Arrays;

/**
 * @author Ivyevy
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("master提交");
        System.out.println("dev冲突提交");
        System.out.println("dev提交");
        System.out.println("第三次提交");
        System.out.println("第二次提交");
        oneToN n = new oneToN();
        int[] x = n.printNumbers(3);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
