package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2017/6/14.
 */
public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, temp, res);
        return res;
    }

    public void findSum(int[] candidates, int target, int sum, int level, List<Integer> temp, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = level; i < candidates.length; i++) {
                temp.add(candidates[i]);
                findSum(candidates, target, sum + candidates[i], i + 1, temp, res);
                temp.remove(temp.size() - 1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }

    public List<List<Integer>> combinationSum21(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    public void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0)
            result.add(new ArrayList<Integer>(cur));

        else if (target > 0) {

            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
