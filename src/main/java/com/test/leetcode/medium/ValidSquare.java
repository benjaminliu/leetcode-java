package com.test.leetcode.medium;

import java.util.HashSet;

/**
 * Created by ben on 2017/6/27.
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet set = new HashSet();
        int d1 = distance(p1, p2);
        int d2 = distance(p1, p3);
        int d3 = distance(p1, p4);
        int d4 = distance(p2, p3);
        int d5 = distance(p2, p4);
        int d6 = distance(p3, p4);
        if (d1 == 0 || d2 == 0 || d3 == 0 || d4 == 0 || d5 == 0 || d6 == 0)
            return false;
        set.add(d1);
        set.add(d2);
        set.add(d3);
        set.add(d4);
        set.add(d5);
        set.add(d6);
        if (set.size() == 2) {
            return true;
        }
        return false;
    }

    private int distance(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }
}
