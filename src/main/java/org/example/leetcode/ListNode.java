package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ivyevy
 * @description:
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     public int getVal() {
          return val;
     }

     public void setVal(int val) {
          this.val = val;
     }

     public ListNode getNext() {
          return next;
     }

     public void setNext(ListNode next) {
          this.next = next;
     }

     public static int[] reversePrint(ListNode head) {
          Stack<Integer> stack = new Stack<>();
          while (head != null) {
               stack.push(head.val);
               head = head.next;
          }
          int[] res = new int[stack.size()];
          int i = 0;
          while (!stack.empty()) {
               res[i] = stack.pop();
               i++;
          }
          return res;
     }

     public static void main(String[] args) {
          ListNode v1 = new ListNode(1);
          ListNode v2 = new ListNode(2);
          ListNode v3 = new ListNode(3);
          v1.next = v2;
          v2.next = v3;
          v3.next = null;
          int[] ints = reversePrint(v1);
          for (int i : ints) {
               System.out.println(i);
          }
     }
}
