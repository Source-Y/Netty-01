package org.example.leetcode;

import java.util.Stack;

/**
 * 双栈实现队列
 */
class CQueue {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;
    public CQueue() {
        this.stackA = new Stack<>();
        this.stackB = new Stack<>();
    }
    
    public void appendTail(int value) {
        stackA.push(value);
    }
    
    public int deleteHead() {
        if (stackA.empty() && stackB.empty()) {
            return -1;
        } else if (!stackB.empty()) {
            return stackB.pop();
        } else {
            while (!stackA.empty()) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
