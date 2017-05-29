package com.test.leetcode.easy;


/**
 * Created by ben on 2017/5/30.
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;
        for (int[] op : ops) {
            if (op[0] < minM) {
                minM = op[0];
            }
            if (op[1] < minN) {
                minN = op[1];
            }
        }
        return minM * minN;
    }

    public int maxCount1(int m, int n, int[][] ops) {
        int[][] arr = new int[m][n];
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    arr[i][j] += 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == arr[0][0])
                    count++;
            }
        }
        return count;

    }
}
