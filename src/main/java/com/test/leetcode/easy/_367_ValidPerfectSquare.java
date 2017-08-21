package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/17.
 */
public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        if(num == 1) return true;

        int start = 2;
        int end = Math.min(46340, num);
        while (start <= end) {
            int mid = (start + end) / 2;
            int square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                end = mid - 1;
            } else {
                start = mid+ 1;
            }
        }
        return false;
    }
}
