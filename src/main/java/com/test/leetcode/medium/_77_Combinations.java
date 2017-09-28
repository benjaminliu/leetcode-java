package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/9.
 */
public class _77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    private List<List<Integer>> list = new ArrayList<List<Integer>>();


    public List<List<Integer>> combine1(int n, int k) {
        if (n <= 0 || k > n || k <= 0)
            return list;
        find(n, k, 1, new ArrayList<Integer>());
        return list;
    }

    private void find(int n, int k, int start, List<Integer> number) {
        if (number.size() == k) {
            list.add(new ArrayList<Integer>(number));

            return;
        }

        for (int i = start; i <= n - (k - number.size()) + 1; i++) {

            number.add(i);
            find(n, k, i + 1, number);
            number.remove(number.size() - 1);
        }
    }
}
