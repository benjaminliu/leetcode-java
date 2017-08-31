package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _661_ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = smoother(M, m, n, i, j);
            }
        }
        return ans;
    }

    private int smoother(int[][] M, int m, int n, int row, int col) {
        int sum = 0, count = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, m - 1); ++i) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, n - 1); ++j) {
                count++;
                sum += M[i][j];
            }
        }
        return sum / count;
    }


    public int[][] imageSmoother1(int[][] M) {
        int lenx = M.length;
        int leny = M[0].length;
        int[][] arr = new int[lenx][leny];
        for (int k = 0; k < lenx; k++) {
            for (int j = 0; j < leny; j++) {
                int sum = M[k][j];
                int cnt = 1;
                if (k - 1 >= 0) {
                    sum += M[k - 1][j];
                    cnt++;
                    if (j - 1 >= 0) {
                        sum += M[k - 1][j - 1];

                        cnt++;
                    }
                    if (j + 1 < leny) {
                        sum += M[k - 1][j + 1];
                        cnt++;
                    }
                }
                if (j - 1 >= 0) {
                    sum += M[k][j - 1];
                    cnt++;
                }

                if (k + 1 < lenx) {
                    sum += M[k + 1][j];
                    cnt++;
                    if (j + 1 < leny) {

                        sum += M[k + 1][j + 1];
                        cnt++;
                    }
                    if (j - 1 >= 0) {
                        sum += M[k + 1][j - 1];
                        cnt++;
                    }
                }
                if (j + 1 < leny) {
                    sum += M[k][j + 1];
                    cnt++;
                }
                int avg = sum / cnt;
                arr[k][j] = avg;
            }
        }
        return arr;

    }


    public int[][] imageSmoother2(int[][] M) {
        int x = M.length;
        int y = M[0].length;
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = calculateNeighboursMedian(M, i, j);
            }
        }
        return result;
    }

    private int calculateNeighboursMedian(int[][] M, int x, int y) {
        int size = 0;
        int total = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < M.length && j >= 0 && j < M[0].length) {
                    size++;
                    total += M[i][j];
                }
            }
        }
        if (size > 0) {
            return total / size;
        } else {
            return 0;
        }
    }
}
