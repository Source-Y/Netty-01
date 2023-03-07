package org.example.leetcode;

class Node {
    private Integer value;
    private Integer newMin;
    private Node next;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getNewMin() {
        return newMin;
    }

    public void setNewMin(Integer newMin) {
        this.newMin = newMin;
    }
}
class MinStack {
    private Node head;
    /** initialize your data structure here. */
    public MinStack() {
        this.head = new Node();
    }
    
    public void push(int x) {
        Node node = new Node();
        node.setValue(x);
        node.setNext(null);
        if (head.getNext() == null) {
            node.setNewMin(x);
            head.setNext(node);
        } else {
            Node tempNode = head.getNext();
            if (x < tempNode.getNewMin()) {
                node.setNewMin(x);
            } else {
                node.setNewMin(tempNode.getNewMin());
            }
            head.setNext(node);
            node.setNext(tempNode);
        }
    }
    
    public void pop() {
        Node headNext = head.getNext();
        head.setNext(headNext.getNext());
    }
    
    public int top() {
        return head.getNext().getValue();
    }
    
    public int min() {
        return head.getNext().getNewMin();
    }
}