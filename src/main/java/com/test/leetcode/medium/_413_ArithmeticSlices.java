package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ben on 2017/5/18.
 */
public class _413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Stack<Integer> arithmetic = new Stack<>();
        int diff = 0;
        int sum = 0;
        int length = A.length;
        arithmetic.add(A[0]);
        for (int i = 1; i < length; i++) {
            if (arithmetic.size() == 1) {
                diff = arithmetic.get(0) - A[i];
                arithmetic.push(A[i]);
                continue;
            }
            if (arithmetic.peek() - A[i] == diff) {
                arithmetic.push(A[i]);
                continue;
            } else {
                if (arithmetic.size() >= 3) {
                    sum += calcSlices(arithmetic.size());
                }
                arithmetic.clear();
                arithmetic.add(A[i]);
            }
        }
        if (arithmetic.size() >= 3) {
            sum += calcSlices(arithmetic.size());
        }
        return sum;
    }

    private int calcSlices(int n) {
        n = n - 2;
        return (n + 1) * n / 2;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        int res = 0;
        int current = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                current += 1;
                res += current;
            } else {
                current = 0;
            }
        }
        return res;
    }
}
