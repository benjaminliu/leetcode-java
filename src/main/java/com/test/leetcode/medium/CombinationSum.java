package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 2017/6/14.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        getResult(candidates, target, 0, result, new int[target], 0);
        return result;
    }

    public void getResult(int[] candidates, int target, int pos, List<List<Integer>> result, int[] ans, int num) {
        for (int i = pos; i < candidates.length; i++) {
            if (target == candidates[i]) {
                List<Integer> aa = new ArrayList<Integer>();
                for (int ii = 0; ii < num; ii++)
                    aa.add(ans[ii]);
                aa.add(candidates[i]);
                result.add(aa);
                return;
            } else if (target > candidates[i]) {
                ans[num] = candidates[i];
                getResult(candidates, target - candidates[i], i, result, ans, num + 1);
            } else
                return;
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i != start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                list.add(candidates[i]);
                backtrack(res, list, candidates, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
