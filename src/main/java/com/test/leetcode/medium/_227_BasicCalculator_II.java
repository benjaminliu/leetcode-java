package com.test.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ben on 2017/10/25.
 */
public class _227_BasicCalculator_II {
    public int calculate(String s) {
        if (null == s || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        int temp = 0;
        int lastOpe = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '+') {
                addByLastOpe(stack, lastOpe, temp);
                lastOpe = 1;
                temp = 0;
            } else if (c == '-') {
                addByLastOpe(stack, lastOpe, temp);
                lastOpe = 2;
                temp = 0;
            } else if (c == '*') {
                addByLastOpe(stack, lastOpe, temp);
                lastOpe = 3;
                temp = 0;
            } else if (c == '/') {
                addByLastOpe(stack, lastOpe, temp);
                lastOpe = 4;
                temp = 0;
            } else {
                temp = temp * 10 + (c - '0');
            }
        }

        addByLastOpe(stack, lastOpe, temp);

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private void addByLastOpe(Stack<Integer> stack, int lastOpe, int temp) {
        int l;
        switch (lastOpe) {
            case 1:
                stack.add(temp);
                break;
            case 2:
                stack.add(temp * -1);
                break;
            case 3:
                l = stack.pop();
                stack.add(l * temp);
                break;
            case 4:
                l = stack.pop();
                stack.add(l / temp);
                break;
            default:
                stack.add(temp);
                break;
        }
    }
}
