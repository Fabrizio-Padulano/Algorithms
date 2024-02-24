package org.padulano.fabrizio.algorithms.datastructures.stacks;

class Node {
    int val;
    int min;

    Node prev;

    public Node(int val, int min, Node prev) {
        this.val = val;
        this.min = min;
        this.prev = prev;
    }
}

/*
    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2

    https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        int min = this.head == null ? val : Math.min(this.head.min, val);
        head = new Node(val, min, this.head);
    }

    public void pop() {
        this.head = this.head.prev;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.head.min;
    }


}
