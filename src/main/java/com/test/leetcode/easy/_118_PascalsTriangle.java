package com.test.leetcode.easy;


import com.test.leetcode.common.IntegerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2017/8/14.
 */
public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        result.add(l1);
        if (numRows == 1) return result;

        int idx = 2;
        int i1, i2;
        List<Integer> temp;
        List<Integer> toAdd;
        while (idx <= numRows) {
            toAdd = new ArrayList<>();
            temp = result.get(idx - 2);

            for (int i = 0; i < idx; i++) {
                if (i - 1 < 0) {
                    i1 = 0;
                } else {
                    i1 = temp.get(i - 1);
                }
                if (i >= temp.size()) {
                    i2 = 0;
                } else {
                    i2 = temp.get(i);
                }
                toAdd.add(i1 + i2);
            }
            result.add(toAdd);
            idx++;
        }
        return result;
    }

    public List<List<Integer>> generate1(int numRows) {
        int n = numRows;
        int num[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            num[i] = new int[i + 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i < 2 || j == 0 || j == i)
                    num[i][j] = 1;
                else
                    num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
            }
        }

        List temp = Arrays.asList(num);
        return temp;
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
