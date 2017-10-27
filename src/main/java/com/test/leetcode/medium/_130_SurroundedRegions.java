package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/28.
 */
public class _130_SurroundedRegions {


    public void solve(char[][] board) {
        if (null == board || board.length == 0 || null == board[0] || board[0].length == 0) return;

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(board, visited, 0, i, row, col);
            dfs(board, visited, row - 1, i, row, col);
        }

        for (int i = 0; i < row; i++) {
            dfs(board, visited, i, 0, row, col);
            dfs(board, visited, i, col - 1, row, col);
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (visited[i][j] == true) continue;
                if (board[i][j] == 'O') board[i][j] = 'X';

                visited[i][j] = true;
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, int row, int col) {
        if (visited[i][j]) return;
        if (board[i][j] == 'X') {
            visited[i][j] = true;
            return;
        }

        visited[i][j] = true;

        if (i > 0 && visited[i - 1][j] == false)
            dfs(board, visited, i - 1, j, row, col);
        if (i < row - 1 && visited[i][j] == false)
            dfs(board, visited, i + 1, j, row, col);
        if (j > 0 && visited[i][j - 1] == false)
            dfs(board, visited, i, j - 1, row, col);
        if (j < col - 1 && visited[i][j + 1] == false)
            dfs(board, visited, i, j + 1, row, col);
    }


    public void solve1(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n - 1] == 'O')
                boundaryDFS(board, i, n - 1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m - 1][j] == 'O')
                boundaryDFS(board, m - 1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i - 1][j] == 'O')
            boundaryDFS(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            boundaryDFS(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            boundaryDFS(board, i, j - 1);
        if (j < board[i].length - 2 && board[i][j + 1] == 'O')
            boundaryDFS(board, i, j + 1);
    }
}
