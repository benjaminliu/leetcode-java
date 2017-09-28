package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/8.
 */
public class _73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {

                    if (!rows.contains(i))
                        rows.add(i);
                    if (!cols.contains(j))
                        cols.add(j);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < n; j++) {
                matrix[rows.get(i)][j] = 0;
            }
        }

        for (int i = 0; i < cols.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][cols.get(i)] = 0;
            }
        }
    }
}
