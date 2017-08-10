package com.test.leetcode.common;

/**
 * Created by ben on 2017/5/22.
 */
public class IntegerUtils {
    public static int getGcd(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        int k;
        while ((k = m % n) != 0) {
            m = n;
            n = k;
        }
        return n;
    }

    public static int getLcm(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        return m * n / getGcd(m, n);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
