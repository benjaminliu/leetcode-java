package com.test.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/5/30.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums != null && nums.length > 1) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int i : nums) {

                if (set.add(i) == false) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
