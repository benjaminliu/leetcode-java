package com.test.others;

/**
 * Created by ben on 2017/7/24.
 */
public class MatrixChainMultiply {
    private int[][] m;
    private int[][] s;

    public int matrixChainOrder(int[] dims) {
        int n = dims.length - 1;
        m = new int[n][n];
        s = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = i + j;
                m[j][k] = Integer.MAX_VALUE;
                for (int l = j; l < k; l++) {
                    int cost = m[j][l] + m[l + 1][k] + dims[j] * dims[l + 1] * dims[k + 1];
                    if (cost < m[j][k]) {
                        m[j][k] = cost;
                        s[j][k] = l;
                    }
                }
            }
        }
        printOptimalParenthesizations();
        return m[0][n - 1];
    }

    public void printOptimalParenthesizations() {
        boolean[] inAResult = new boolean[s.length];
        printOptimalParenthesizations(s, 0, s.length - 1, inAResult);
    }

    void printOptimalParenthesizations(int[][] s, int i, int j,  /* for pretty printing: */ boolean[] inAResult) {
        if (i != j) {
            printOptimalParenthesizations(s, i, s[i][j], inAResult);
            printOptimalParenthesizations(s, s[i][j] + 1, j, inAResult);
            String istr = inAResult[i] ? "_result " : " ";
            String jstr = inAResult[j] ? "_result " : " ";
            System.out.println(" A_" + i + istr + "* A_" + j + jstr);
            inAResult[i] = true;
            inAResult[j] = true;
        }
    }
}
