package com.test.leetcode.easy;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by ben on 2017/8/14.
 */
public class _155_MinStack {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> min = new LinkedList<>();

    public _155_MinStack() {

    }

    public void push(int x) {
        stack.addFirst(x);
        if (min.isEmpty()) {
            min.addFirst(x);
        } else if (x <= min.peek()) {
            min.addFirst(x);
        }
    }

    public void pop() {
        int i = stack.removeFirst();
        if (i == min.getFirst()) {
            min.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return min.getFirst();
    }
}
