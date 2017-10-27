package com.test.leetcode.medium;

import java.util.Stack;

/**
 * Created by ben on 2017/10/17.
 */
public class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (null == tokens || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int left;
        int right;

        for (String node : tokens) {
            switch (node) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    int n = Integer.parseInt(node);
                    stack.push(n);
            }
        }

        return stack.peek();
    }
}
