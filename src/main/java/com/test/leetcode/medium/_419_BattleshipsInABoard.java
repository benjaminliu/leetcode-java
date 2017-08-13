package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/15.
 */
public class _419_BattleshipsInABoard {
    private final static char x = 'X';

    public int countBattleships(char[][] board) {
        if (board == null || board[0] == null) {
            throw new IllegalArgumentException("board");
        }

        int row = board.length;
        int column = board[0].length;

        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                visited[i][j] = false;
            }
        }

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == x && visited[i][j] == false) {
                    visited[i][j] = true;
                    if (i == row - 1) {

                    } else if (j == column - 1) {

                    } else if (board[i][j + 1] == x && board[i + 1][j] == x) {
                        return -1;
                    }

                    count++;
                    markRow(board, visited, i, j, column);
                    markCollumn(board, visited, i, j, row);
                }
            }
        }
        return count;
    }

    private void markCollumn(char[][] board, boolean[][] visited, int row, int column, int maxRow) {

        for (int i = row + 1; i < maxRow; i++) {
            if (board[i][column] != x) {
                return;
            }
            visited[i][column] = true;
        }

    }

    private void markRow(char[][] board, boolean[][] visited, int row, int column, int maxColumn) {
        for (int i = column + 1; i < maxColumn; i++) {
            if (board[row][i] != x) {
                return;
            }

            visited[row][i] = true;
        }
    }

    public int countBattleships2(char[][] board) {
        if (board == null || board[0] == null) {
            throw new IllegalArgumentException("board");
        }

        int row = board.length;
        int column = board[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == x) {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == x) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
