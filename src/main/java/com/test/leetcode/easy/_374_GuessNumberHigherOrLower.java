package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/17.
 */
public class _374_GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int guess(int num) {
        if (num == 6) {
            return 0;
        } else if (num > 6) {
            return 1;
        } else {
            return -1;
        }
    }
}
