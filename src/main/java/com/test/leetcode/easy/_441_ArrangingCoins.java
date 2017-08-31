package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/23.
 */
public class _441_ArrangingCoins {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public int arrangeCoins1(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long) n) - 1) / 2);
    }
}
