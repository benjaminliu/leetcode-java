package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/24.
 */
public class _507_PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        sum++;

        return sum == num;
    }
}
