package com.test.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/6/3.
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) {
            return new ArrayList<>();
        }
        int[][] grid = new int[m][n];
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];

            grid[position[0]][position[1]] = 1;

            if (i > 0) {
                if (grid[i - 1][j] == 1) {
                    res.add(count);
                    continue;
                }
            }
            if (i + 1 < m) {
                if (grid[i + 1][j] == 1) {
                    res.add(count);
                    continue;
                }
            }
            if (j > 0) {
                if (grid[i][j - 1] == 1) {
                    res.add(count);
                    continue;
                }
            }
            if (j + 1 < n) {
                if (grid[i][j + 1] == 1) {
                    res.add(count);
                    continue;
                }
            }
            count++;
            res.add(count);
        }
        return res;
    }
}
