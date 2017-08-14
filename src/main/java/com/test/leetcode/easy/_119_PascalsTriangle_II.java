package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/14.
 */
public class _119_PascalsTriangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;
        result.add(1);
        if (rowIndex == 0) return result;

        int idx = 1;
        int i1, i2;
        List<Integer> temp;
        while (idx <= rowIndex) {
            temp = new ArrayList<>();
            for (int i = 0; i <= idx; i++) {
                if (i - 1 < 0) {
                    i1 = 0;
                } else {
                    i1 = result.get(i - 1);
                }
                if (i >= result.size()) {
                    i2 = 0;
                } else {
                    i2 = result.get(i);
                }

                temp.add(i1 + i2);
            }
            result = temp;
            idx++;
        }
        return result;
    }


    public List<Integer> getRow1(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        for (int i = 1; i <= rowIndex / 2; i++) {
            long t = (long) result.get(i - 1) * (rowIndex - i + 1) / i;
            result.add((int) t);
        }
        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++) {
            result.add(result.get(rowIndex - i));
        }
        return result;
    }
}
