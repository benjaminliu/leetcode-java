package com.test.leetcode.medium;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ben on 2017/7/21.
 */
public class _36_ValidSudoku {

    private Set<Character> set1 = new HashSet<>(9);
    private final char dot = '.';

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board[0] == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            set1.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == dot) {
                    continue;
                }
                if (!set1.add(board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            set1.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == dot) {
                    continue;
                }
                if (!set1.add(board[j][i])) {
                    return false;
                }
            }
        }

        if (!check(board, 0, 3, 0, 3)) {
            return false;
        }
        if (!check(board, 0, 3, 3, 6)) {
            return false;
        }
        if (!check(board, 0, 3, 6, 9)) {
            return false;
        }
        if (!check(board, 3, 6, 0, 3)) {
            return false;
        }
        if (!check(board, 3, 6, 3, 6)) {
            return false;
        }
        if (!check(board, 3, 6, 6, 9)) {
            return false;
        }
        if (!check(board, 6, 9, 0, 3)) {
            return false;
        }
        if (!check(board, 6, 9, 3, 6)) {
            return false;
        }
        if (!check(board, 6, 9, 6, 9)) {
            return false;
        }
        return true;
    }

    private boolean check(char[][] board, int iStart, int iEnd, int jStart, int jEnd) {
        set1.clear();
        for (int i = iStart; i < iEnd; i++) {
            for (int j = jStart; j < jEnd; j++) {
                if (board[i][j] == dot) {
                    continue;
                }
                if (!set1.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
