package com.test.leetcode.easy;

import com.test.leetcode.common.IntegerUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ben on 2017/8/14.
 */
public class _219_ContainsDuplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (null == nums || nums.length == 0) return false;

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Integer j = map.get(nums[i]);
            if (null != j) {
                if (i - j <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //the set only hold i-k to i-1 nums, when we insert i num, check if it duplicate
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
