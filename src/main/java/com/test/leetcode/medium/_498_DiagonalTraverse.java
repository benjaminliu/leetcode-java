package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/9.
 */
public class _498_DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0];

        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;
        int[] result = new int[len];
        int idx = 0;
        int i = 0;
        int j = 0;
        boolean up = true;
        while (idx < len) {
            result[idx++] = matrix[i][j];

            if (up) {
                if (i == 0 || j == col - 1) {
                    up = false;
                    if (j == col - 1) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i--;
                    j++;
                }
            } else {
                if (j == 0 || i == row - 1) {
                    up = true;
                    if (i == row - 1) {
                        j++;
                    } else if (j == 0) {
                        i++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}
