package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/14.
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int length = r * c;
        int column = nums[0].length;
        int row = nums.length;
        if (row * column != length) {
            return nums;
        }

        int[] news = new int[length];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                news[index++] = nums[i][j];
            }
        }

        index = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = news[index++];
            }
        }
        return result;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int length = r * c;
        int column = nums[0].length;
        int row = nums.length;
        if (row * column != length) {
            return nums;
        }
        int rr = 0;
        int cc = 0;

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[rr][cc++];
                if (cc == column) {
                    cc = 0;
                    rr++;
                }
            }
        }
        return result;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }

        int[][] newMatrix = new int[r][c];

        for (int i = 0; i < row * column; i++) {
            newMatrix[i / c][i % c] = nums[i / column][i % column];
        }
        return newMatrix;
    }
}
