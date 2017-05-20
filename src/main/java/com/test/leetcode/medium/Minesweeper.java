package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/20.
 */
public class Minesweeper {
    private static final char M = 'M';
    private static final char E = 'E';
    private static final char B = 'B';
    private static final char X = 'X';

    private int[][] neighbors = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private char[] mines = {'B', '1', '2', '3', '4', '5', '6', '7', '8'};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return board;
        }

        if (board[click[0]][click[1]] == M) {
            board[click[0]][click[1]] = X;
            return board;
        }

        int m = board.length;
        int n = board[0].length;
        dfs(board, click[0], click[1], m, n);
        return board;
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (board[i][j] == E) {
            int count = 0;
            for (int[] neighbor : neighbors) {
                int tempi = i + neighbor[0];
                int tempj = j + neighbor[1];
                if (tempi >= 0 && tempi < m && tempj >= 0 && tempj < n) {
                    if (board[tempi][tempj] == M) {
                        count++;
                    }
                }
            }
            board[i][j] = mines[count];
            if (board[i][j] == B) {
                for (int[] neighbor : neighbors) {
                    dfs(board, i + neighbor[0], j + neighbor[1], m, n);
                }
            }
        }
    }
}
