package com.test.leetcode.easy;

/**
 * Created by ben on 2017/6/18.
 */
public class SqrtX {


    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        long j = 0;
        long i = 1;
        while (i * 2 <= x) {
            i = i * 2;
        }

        while (j <= i) {
            long mid = j + (i - j) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square > x) {
                i = mid - 1;
            } else {
                j = mid + 1;
            }
        }

        return (int) i;
    }

    public int sqrt1(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;

        int l = 1;
        int r = x / 2 + 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m <= x / m && x / (m + 1) < m + 1)
                return m;
            if (x / m < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }

    public int mySqrt2(int x) {
        int left = 0;
        int right = x / 2 + 1;
        long mid = 0;      //the long type prevent the overflow of int
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (mid * mid == x) {  // if mid is int , here may be fault, multiply
                return (int) mid;
            } else if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return right;
    }
}
