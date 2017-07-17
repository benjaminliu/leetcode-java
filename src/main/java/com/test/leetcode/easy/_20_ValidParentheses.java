package com.test.leetcode.easy;

import java.util.Stack;

/**
 * Created by ben on 2017/7/14.
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char big = '{';
        char middle = '[';
        char small = '(';

        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            switch (c) {
                case '}':

                    if (stack.isEmpty() || stack.pop() != big) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != middle) {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != small) {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
