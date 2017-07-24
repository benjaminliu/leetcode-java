package com.test.leetcode.hard;

import java.util.Stack;

/**
 * Created by ben on 2017/7/21.
 */
public class _32_LongestValidParentheses {


    public int longestValidParentheses(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int last = -1;
        final char left = '(';

        int max = 0;
        int len = cs.length;

        Stack<Integer> stack = new Stack<>();
        int temp;

        for (int i = 0; i < len; i++) {
            if (cs[i] == left) {
                stack.push(i);
            } else {
                if (stack.size() == 0) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        temp = i - last;
                        if (max < temp) {
                            max = temp;
                        }
                    } else {
                        temp = i - stack.peek();
                        if (max < temp) {
                            max = temp;
                        }
                    }
                }
            }
        }

        return max;
    }

    public int longestValidParentheses1(String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        char[] chars = string.toCharArray();
        int[] dp = new int[string.length()];
        int pre = 0;
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
