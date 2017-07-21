package com.test.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/21.
 */
public class _52_NQueensII {
    private final char QUEUE = 'Q';
    private final char EMPTY = '.';
    private int count;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        char[][] queues = new char[n][n];
        for (int i = 0; i < n; i++) {
            queues[i] = new char[n];
            for (int j = 0; j < n; j++) {
                queues[i][j] = EMPTY;
            }
        }

        dfs(queues, 0, n);

        return count;
    }

    private void dfs(char[][] queues, int col, int n) {
        if (col == n) {
            count++;
            //add
        } else {
            for (int i = 0; i < n; i++) {
                if (canBeQueue(queues, i, col, n)) {
                    queues[i][col] = QUEUE;
                    dfs(queues, col + 1, n);
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

    private long limit;
    private int sum;

    public int totalNQueens1(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // N个皇后只需N位存储，N列中某列有皇后则对应bit置1。
        limit = (1 << n) - 1;

        helper(0, 0, 0);
        return sum;
    }

    private void helper(long row, long ld, long rd) {
        //row ==  11111111  (n个1)
        if (row != limit) {
            // row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，
            // 然后再取反后“与”上全1的数，来求得当前所有可以放置皇后的位置，对应列改为1
            // 也就是求取当前哪些列可以放置皇后
            long pos = limit & ~(row | ld | rd);
            // 0 -- 皇后没有地方可放，回溯
            while (pos != 0) {
                // 拷贝pos最右边为1的bit，其余bit置0
                // 也就是取得可以放皇后的最右边的列
                long p = pos & -pos;
                // 将pos最右边为1的bit清零
                // 也就是为获取下一次的最右可用列使用做准备，
                // 程序将来会回溯到这个位置继续试探
                pos -= p;
                // row + p，将当前列置1，表示记录这次皇后放置的列。
                // (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置。
                // (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置。
                // 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归
                // 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位
                // 在每次选择列之前进行，原来N×N网格中某个已放置的皇后针对其对角线
                // 上产生的限制都被记录下来了
                helper(row + p, (ld + p) << 1, (rd + p) >> 1);
            }
        } else {
            // row的所有位都为1，即找到了一个成功的布局，回溯
            sum++;
        }
    }
}
