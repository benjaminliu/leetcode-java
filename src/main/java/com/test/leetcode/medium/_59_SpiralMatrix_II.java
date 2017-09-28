package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/1.
 */
public class _59_SpiralMatrix_II {
    public int[][] generateMatrix(int n) {
        if (n < 1) return new int[0][0];
        if (n == 1) {
            int[][] res = new int[1][1];
            res[0][0] = 1;
            return res;
        }

        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int direction = 1;
        int a = 0, b = 0;
        int value = 1;
        while (up <= down && left <= right) {
            switch (direction) {
                case 1://go right
                    do {
                        matrix[a][b] = value++;
                        b++;
                    } while (b <= right);
                    a++;
                    b--;
                    up++;
                    direction = 2;
                    break;
                case 2://go down
                    do {
                        matrix[a][b] = value++;
                        a++;
                    } while (a <= down);
                    b--;
                    a--;
                    right--;
                    direction = 3;
                    break;
                case 3://go left
                    do {
                        matrix[a][b] = value++;
                        b--;
                    } while (b >= left);
                    a--;
                    b++;
                    down--;
                    direction = 4;
                    break;
                default://go up
                    do {
                        matrix[a][b] = value++;
                        a--;
                    }
                    while (a >= up);
                    b++;
                    a++;
                    left++;
                    direction = 1;
                    break;
            }
        }
        return matrix;
    }
}
