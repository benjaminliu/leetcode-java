package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/6/2.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (null == board || 0 == board.length || null == board[0] || 0 == board[0].length) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        if (word.length() > m * n) {
            return false;
        }
        char[] arr = word.toCharArray();
        Set<String> visited = new HashSet<>(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(board, i, j, arr, 0, visited)) {
                        return true;
                    }
                    visited.clear();
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] arr, int k, Set<String> visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || k >= arr.length) {
            return false;
        }
        if (board[i][j] != arr[k]) {
            return false;
        }
        String key = i + ":" + j;
//        System.out.println(key + " - " + arr[k]);
        if (!visited.add(key)) {
            return false;
        }

        if (k == arr.length - 1) {
            return true;
        }

        if (dfs(board, i - 1, j, arr, k + 1, visited)) {
            return true;
        }
        if (dfs(board, i + 1, j, arr, k + 1, visited)) {
            return true;
        }
        if (dfs(board, i, j - 1, arr, k + 1, visited)) {
            return true;
        }
        if (dfs(board, i, j + 1, arr, k + 1, visited)) {
            return true;
        }
        visited.remove(key);
        return false;
    }


    public boolean exist1(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word == null || word.length() == 0)
            return true;

        char[] wordArray = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArray[0] && existWord(board, i, j, wordArray, 1))
                    return true;
            }
        }
        return false;
    }

    private boolean existWord(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length)
            return true;

        char stored = board[i][j];
        board[i][j] = '*';
        boolean exist = i > 0 && board[i - 1][j] == word[index] && existWord(board, i - 1, j, word, index + 1)
                || i + 1 < board.length && board[i + 1][j] == word[index] && existWord(board, i + 1, j, word, index + 1)
                || j > 0 && board[i][j - 1] == word[index] && existWord(board, i, j - 1, word, index + 1)
                || j + 1 < board[0].length && board[i][j + 1] == word[index] && existWord(board, i, j + 1, word, index + 1);
        board[i][j] = stored;
        return exist;
    }
}
