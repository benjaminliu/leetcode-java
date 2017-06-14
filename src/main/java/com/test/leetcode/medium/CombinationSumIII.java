package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/6/14.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (k < 1 || n < 1 || k > n) return result;
        dfs(result, cur, 0, k, n, 1);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> cur, int sum, int k, int n, int level) {
        if (sum == n && k == 0) {
            result.add(new ArrayList(cur));
            return;
        } else if (sum > n || k < 0) return;
        for (int i = level; i <= 9; i++) {
            cur.add(i);
            dfs(result, cur, sum + i, k - 1, n, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
