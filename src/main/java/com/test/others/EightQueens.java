package com.test.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/6/7.
 */
public class EightQueens {
    private static final int GRID_SIZE = 8;

    public List<Integer[]> place8Queens() {
        List<Integer[]> res = new ArrayList<>();
        Integer[] columns = new Integer[8];
        placeQueens(0, columns, res);
        return res;
    }

    private void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean checkValid(Integer[] columns, int row, int col) {
        for (int r = 0; r < row; r++) {
            int c = columns[r];
            if (c == col) {
                return false;
            }

            int cDistance = Math.abs(c - col);
            int rDistance = Math.abs(r - row);

            //in save diagonal
            if (cDistance == rDistance) {
                return false;
            }
        }
        return true;
    }
}
