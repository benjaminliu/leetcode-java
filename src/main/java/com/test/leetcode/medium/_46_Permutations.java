package com.test.leetcode.medium;


import com.test.leetcode.common.IntegerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/10.
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) return result;

        if (nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            result.add(l);
            return result;
        }

        int len = nums.length;

        Integer[] ns = new Integer[len];
        for (int i = 0; i < len; i++) {
            ns[i] = nums[i];
        }

        int temp;
        int[] l = new int[len];
        for (int i = 0; i < len; i++) {
            temp = ns[i];
            l[0] = temp;
            ns[i] = null;
            helper(result, ns, l, 1, len);
            ns[i] = temp;
        }
        return result;
    }

    private void helper(List<List<Integer>> result, Integer[] ns, int[] l, int idx, int len) {
        if (idx == len) {
            List<Integer> ls = new ArrayList<>();
            for (int i : l) {
                ls.add(i);
            }
            result.add(ls);
            return;
        }
        int temp;
        for (int i = 0; i < len; i++) {
            if (ns[i] != null) {
                temp = ns[i];
                l[idx] = temp;
                ns[i] = null;
                helper(result, ns, l, idx + 1, len);
                ns[i] = temp;
            }
        }
    }


    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void backtracking(List<List<Integer>> res, int[] nums, int pos, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            IntegerUtils.swap(nums, i, pos);
            backtracking(res, nums, pos + 1, list);
            IntegerUtils.swap(nums, i, pos);
            list.remove(list.size() - 1);
        }
    }
}
