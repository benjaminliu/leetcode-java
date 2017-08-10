package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/8/7.
 */
public class _421_MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num & mask);

            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
