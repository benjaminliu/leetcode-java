package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/1.
 */
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;

        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        int direction = 1;
        int a = 0, b = 0;
        while (up <= down && left <= right) {
            switch (direction) {
                case 1://go right
                    do {
                        res.add(matrix[a][b]);
                        b++;
                    } while (b <= right);
                    a++;
                    b--;
                    up++;
                    direction = 2;
                    break;
                case 2://go down
                    do {
                        res.add(matrix[a][b]);
                        a++;
                    } while (a <= down);
                    b--;
                    a--;
                    right--;
                    direction = 3;
                    break;
                case 3://go left
                    do {
                        res.add(matrix[a][b]);
                        b--;
                    } while (b >= left);
                    a--;
                    b++;
                    down--;
                    direction = 4;
                    break;
                default://go up
                    do {
                        res.add(matrix[a][b]);
                        a--;
                    }
                    while (a >= up);
                    b++;
                    a++;
                    left++;
                    direction = 1;
                    break;
            }
        }
        return res;
    }
}
