package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/17.
 */
public class _374_GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int g = guess(mid);
            if (g == 0) return mid;
            else if (g == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    public int guessNumber1(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    int guess(int num) {
        int compare = 1;
        if (num == compare) {
            return 0;
        } else if (num > compare) {
            return -1;
        } else {
            return 1;
        }
    }
}
