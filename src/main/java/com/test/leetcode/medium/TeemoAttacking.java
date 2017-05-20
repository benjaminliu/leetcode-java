package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/20.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration < 1) {
            return 0;
        }
        int length = timeSeries.length;
        if (length > 10000 || duration > 10000000) {
            throw new IndexOutOfBoundsException("argument out of bounds");
        }
        double sum = 0;
        int temp;
        for (int i = 0, loop = length - 1; i < loop; i++) {
            temp = timeSeries[i + 1] - timeSeries[i];
            if (temp >= duration) {
                sum += duration;
            } else {
                sum += temp;
            }
        }
        sum += duration;
        return (int) sum;
    }
}
