package com.test.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/8/11.
 */
public class _640_SolveTheEquation {
    private final String NoSolution = "No solution";
    private final String InfiniteSolutions = "Infinite solutions";
    private final char X = 'x';
    private final char Plus = '+';
    private final char Minus = '-';
    private final char Equal = '=';
    private final char Zero = '0';

    public String solveEquation(String equation) {
        if (null == equation || equation.length() == 0) return NoSolution;

        int xSum = 0;
        int noSum = 0;
        int beforeEqual = 1;
        int isPositive = 1;

        int len = equation.length();
        char c;
        int temp = 0;
        int num;
        for (int i = 0; i < len; i++) {
            c = equation.charAt(i);
            if (c == Equal) {
                if (temp != 0) {
                    num = -1 * beforeEqual * isPositive * temp;
                    noSum += num;
                    temp = 0;
                }
                beforeEqual = -1;
                isPositive = 1;
            } else if (c == Plus || c == Minus) {
                if (temp != 0) {
                    num = -1 * beforeEqual * isPositive * temp;
                    noSum += num;
                    temp = 0;
                }
                if (c == Plus) {
                    isPositive = 1;
                } else {
                    isPositive = -1;
                }
            } else if (c == X) {
                if (temp == 0) {
                    if (i > 0 && equation.charAt(i - 1) == Zero) {

                    } else {
                        temp = 1;
                    }
                }
                num = beforeEqual * isPositive * temp;
                xSum += num;
                temp = 0;
                isPositive = 1;
            } else {
                temp = temp * 10 + (c - Zero);
            }
        }
        if (temp != 0) {
            noSum += -1 * beforeEqual * isPositive * temp;
        }

        if (xSum == 0) {
            if (noSum == 0) {
                return InfiniteSolutions;
            }
            return NoSolution;
        }

        num = noSum / xSum;

        return "x=" + num;
    }
}
