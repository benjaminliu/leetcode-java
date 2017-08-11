package com.test.leetcode.medium;

import com.test.leetcode.common.IntegerUtils;

/**
 * Created by ben on 2017/8/11.
 */
public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;

        int len = matrix.length;
        int temp;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int half = len / 2;
        int idxj;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < half; j++) {
                temp = matrix[i][j];
                idxj = len - j - 1;
                matrix[i][j] = matrix[i][idxj];
                matrix[i][idxj] = temp;
            }
        }
    }
}
