package com.test.leetcode.easy;

import com.test.leetcode.common.IntegerUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/5/24.
 */
public class _496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null || nums == null || findNums.length > nums.length) {
            return new int[0];
        }
        int lenghtF = findNums.length;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[lenghtF];
        for (int i = 0; i < lenghtF; i++) {
            int l = map.get(findNums[i]) + 1;
            res[i] = -1;
            for (; l < length; l++) {
                if (nums[l] > findNums[i]) {
                    res[i] = nums[l];
                    break;
                }
            }
        }
        return res;
    }
}
