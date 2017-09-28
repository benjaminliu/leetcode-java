package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/8.
 */
public class _74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] > target) return false;
        if (matrix[m - 1][n - 1] < target) return false;
        int start, end, mid;
        int row = 0;
        if (m > 1) {
            start = 0;
            end = m - 1;

            while (start <= end) {
                mid = start + (end - start) / 2;
                if (matrix[mid][0] == target) return true;

                if (matrix[mid][0] > target) {
                    end = mid;
                } else {
                    if (mid + 1 >= m) {
                        row = mid;
                        break;
                    }
                    if (matrix[mid + 1][0] == target) return true;
                    else if (matrix[mid + 1][0] > target) {
                        row = mid;
                        break;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }

        if (n > 1) {
            start = 0;
            end = n - 1;

            while (start <= end) {
                mid = start + (end - start) / 2;
                if (matrix[row][mid] == target) return true;
                if (matrix[row][mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return false;
        } else {
            return matrix[row][0] == target;
        }
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
