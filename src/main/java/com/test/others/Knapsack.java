package com.test.others;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/24.
 */
public class Knapsack {
    public int knapsack(int[][] goods, int w) {
        int len = goods.length;
        int[][] v = new int[len + 1][w + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= w; j++) {
                //when there is enough space for another goods, we should add it up
                if (j >= goods[i - 1][0]) {
                    //how many space left
                    int t = j - goods[i - 1][0];
                    int cost = goods[i - 1][1] + v[i - 1][t];
                    v[i][j] = Math.max(cost, v[i - 1][j]);
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= len; i++) {
            System.out.print(Arrays.toString(v[i]));
            System.out.println();
        }
        return v[len][w];
    }
}
