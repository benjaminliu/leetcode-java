package com.test.leetcode.easy;

import java.util.Stack;

/**
 * Created by ben on 2017/5/15.
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (c == ' ') {
                popStack(sb, stack);
                sb.append(c);
                continue;
            }
            stack.push(c);
        }
        popStack(sb, stack);

        return sb.toString();
    }

    private void popStack(StringBuilder sb, Stack<Character> stack) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    public String reverseWords1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;
        char[] cs = s.toCharArray();
        for (int i = 0, lenght = cs.length; i < lenght; i++) {
            end = i;
            if (cs[i] == ' ') {
                end = i - 1;
                reverseCharArray(cs, start, end);
                start = i + 1;
            }
        }
        reverseCharArray(cs, start, end);

        return new String(cs);
    }

    private void reverseCharArray(char[] cs, int start, int end) {
        char temp;
        while (start < end) {
            temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
    }
}
