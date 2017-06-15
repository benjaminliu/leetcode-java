package com.test.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ben on 2017/6/15.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (null == num1 || num1.length() == 0) {
            return num2;
        }
        if (null == num2 || num2.length() == 0) {
            return num1;
        }
        if (num1.length() > num2.length()) {
            return addStrings(num2, num1);
        }

        Stack<String> stack = new Stack<>();

        int length = num1.length();
        int length2 = num2.length();
        final int max = 1000000000;
        String s1;
        String s2;
        boolean needAdd1 = false;
        while (length > 0) {
            length -= 9;
            length2 -= 9;
            if (length >= 1) {
                s1 = num1.substring(length, length + 9);
            } else {
                s1 = num1.substring(0, 9 + length);
            }
            if (length2 >= 1) {
                s2 = num2.substring(length2, length2 + 9);
            } else {
                s2 = num2.substring(0, 9 + length2);
            }
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            int sum = i1 + i2;
            if (needAdd1) {
                sum++;
            }

            if (sum >= max) {
                needAdd1 = true;
                sum -= max;
            } else {
                needAdd1 = false;
            }
            stack.push(String.valueOf(sum));
        }
        while (length2 >= 1) {
            length2 -= 9;
            if (length2 >= 1) {
                s2 = num2.substring(length2, length2 + 9);
            } else {
                s2 = num2.substring(0, 9 + length2);
            }
            int sum = Integer.parseInt(s2);
            if (needAdd1) {
                sum++;
            }

            if (sum >= max) {
                needAdd1 = true;
                sum -= max;
            } else {
                needAdd1 = false;
            }
            stack.push(String.valueOf(sum));
        }
        StringBuilder sb = new StringBuilder();
        if (needAdd1) {
            sb.append(1);
        } else {
            sb.append(stack.pop());
        }
        while (!stack.isEmpty()) {
            String str = stack.pop();
            int zeroCount = 9 - str.length();
            String zeros = "";
            switch (zeroCount) {
                case 1:
                    zeros = "0";
                    break;
                case 2:
                    zeros = "00";
                    break;
                case 3:
                    zeros = "000";
                    break;
                case 4:
                    zeros = "0000";
                    break;
                case 5:
                    zeros = "00000";
                    break;
                case 6:
                    zeros = "000000";
                    break;
                case 7:
                    zeros = "0000000";
                    break;
                case 8:
                    zeros = "00000000";
                    break;
                case 9:
                    zeros = "000000000";
                    break;
                default:
                    break;
            }
            sb.append(zeros + str);
        }
        return sb.toString();
    }
}
