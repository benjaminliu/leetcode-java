package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ben on 2017/5/19.
 */
public class _442_FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            if (!set.add(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        int length = nums.length;
        int[] mark = new int[length + 1];

        for (int i = 0; i < length; i++) {
            mark[nums[i]] = 0;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            mark[nums[i]]++;
            if (mark[nums[i]] > 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
