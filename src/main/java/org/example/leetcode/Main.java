package org.example.leetcode;

import java.util.Arrays;

/**
 * @author Ivyevy
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("666");
        System.out.println("master远程库被修改本地");
        System.out.println("master远程库被修改远程");
        System.out.println("master提交远程库");
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
