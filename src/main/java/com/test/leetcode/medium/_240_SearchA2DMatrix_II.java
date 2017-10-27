package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/27.
 */
public class _240_SearchA2DMatrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        boolean res = dfs(matrix, target, 0, 0, row, col);
        return res;
    }

    private boolean dfs(int[][] matrix, int target, int i, int j, int row, int col) {
        if (i >= row) return false;
        if (j >= col) return false;

        if (matrix[i][j] == target) return true;
        if (matrix[i][j] > target) return false;

        boolean right = dfs(matrix, target, i, j + 1, row, col);
        if (true == right) return true;

        boolean down = dfs(matrix, target, i + 1, j, row, col);
        if (true == down) return true;

        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int j = col - 1;
        int i = 0;

        while (j >= 0 && i < row) {
            if (target == matrix[i][j]) return true;
            if (target > matrix[i][j]) i++;
            else j--;
        }
        return false;
    }
}
