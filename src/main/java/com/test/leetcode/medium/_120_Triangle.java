package com.test.leetcode.medium;

import java.util.List;

/**
 * Created by ben on 2017/9/28.
 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        List<Integer> temp;
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            temp = triangle.get(i);
            int size1 = temp.size() - 1;
            dp[i][0] = temp.get(0) + dp[i - 1][0];
            dp[i][size1] = temp.get(size1) + dp[i - 1][size1 - 1];

            for (int j = 1; j < size1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + temp.get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (min > dp[size - 1][i]) min = dp[size - 1][i];
        }
        return min;
    }
}
