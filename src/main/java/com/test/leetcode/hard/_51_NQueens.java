package com.test.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/20.
 */
public class _51_NQueens {

    private final char QUEUE = 'Q';
    private final char EMPTY = '.';

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        if (n == 1) {
            List<String> l = new ArrayList<>();
            l.add("Q");
            result.add(l);
            return result;
        }

        char[][] queues = new char[n][n];
        for (int i = 0; i < n; i++) {
            queues[i] = new char[n];
            for (int j = 0; j < n; j++) {
                queues[i][j] = EMPTY;
            }
        }

        dfs(result, queues, 0, n);

        return result;
    }

    private void dfs(List<List<String>> result, char[][] queues, int col, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(new String(queues[i]));
            }
            result.add(list);
            //add
        } else {
            for (int i = 0; i < n; i++) {
                if (canBeQueue(queues, i, col, n)) {
                    queues[i][col] = QUEUE;
                    dfs(result, queues, col + 1, n);
                    queues[i][col] = EMPTY;
                }
            }
        }
    }

    private boolean canBeQueue(char[][] queues, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (queues[row][i] == QUEUE) {
                return false;
            }
        }

        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (queues[i--][j--] == QUEUE) {
                return false;
            }
        }
        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0) {
            if (queues[i++][j--] == QUEUE) {
                return false;
            }
        }
        return true;
    }
}
