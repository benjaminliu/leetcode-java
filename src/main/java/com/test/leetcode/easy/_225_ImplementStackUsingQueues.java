package com.test.leetcode.easy;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/8/15.
 */
public class _225_ImplementStackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public _225_ImplementStackUsingQueues() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q1.isEmpty()) {
            throw new EmptyStackException();
        }
        transferAndLeave1();
        int x = q1.poll();
        switchQueue();
        return x;
    }

    private void transferAndLeave1() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
    }

    private void switchQueue() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (q1.isEmpty()) {
            throw new EmptyStackException();
        }
        transferAndLeave1();
        int x = q1.poll();
        switchQueue();
        q1.add(x);
        return x;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
