package com.test.leetcode.easy;

import java.util.*;

/**
 * Created by ben on 2017/8/31.
 */
public class _594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {

        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        if (map.size() == 1) return 0;

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        while (entry != null) {
            list.add(entry);
            entry = map.pollFirstEntry();
        }

        Map.Entry<Integer, Integer> entry1;
        entry = list.get(0);
        int max = 0;
        int sum;
        for (int i = 1; i < list.size(); i++) {
            entry1 = entry;
            entry = list.get(i);
            if (entry.getKey() == entry1.getKey() + 1) {
                sum = entry.getValue() + entry1.getValue();
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int prev_count = 1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                res = Math.max(res, count + prev_count);
                prev_count = count;
            } else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                prev_count = count;
            }
        }
        return res;
    }
}
