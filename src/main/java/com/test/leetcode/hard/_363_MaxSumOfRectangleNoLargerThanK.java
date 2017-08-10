package com.test.leetcode.hard;

import java.util.TreeSet;

/**
 * Created by ben on 2017/8/7.
 */
public class _363_MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int re = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int csum = 0;
                // csum - sum <=k, csum - k <= sum
                for (int sum : sums) {
                    csum += sum;
                    Integer tmp = set.ceiling(csum - k);
                    if (tmp != null) re = Math.max(re, csum - tmp);
                    set.add(csum);
                }
            }
        }
        return re;
    }
}
