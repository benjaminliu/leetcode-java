package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/31.
 */
public class _289_GameOfLife {

    //board[i][j]
    //==0, before die, after die, 死的死
    //==1, before live, after die, 活的死
    //==10, before die, after live, 死的活
    //==11, before live, after live, 活的活
    public void gameOfLife(int[][] board) {
        //check input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = getLiveNum(board, i, j);
                if (board[i][j] == 0) {
                    if (x == 3) board[i][j] += 10;
                } else {
                    if (x == 2 || x == 3) board[i][j] += 10;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] /= 10;
            }
        }
    }

    private int getLiveNum(int[][] board, int x, int y) {
        int c = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || (i == x && j == y)) continue;
                if (board[i][j] % 10 == 1) c++;
            }
        }
        return c;
    }


    public void gameOfLife1(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int aliveN = liveNeigh(board, i, j);
                if (board[i][j] == 1 && (aliveN == 2 || aliveN == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && aliveN == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    private int liveNeigh(int[][] board, int r, int c) {
        int alive = 0;
        for (int i = r - 1; i <= r + 1; ++i) {
            for (int j = c - 1; j <= c + 1; ++j) {
                if (i == r && j == c) {
                    continue;
                }
                if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                    continue;
                }
                alive += (board[i][j] & 1);
            }
        }
        return alive;
    }
}
