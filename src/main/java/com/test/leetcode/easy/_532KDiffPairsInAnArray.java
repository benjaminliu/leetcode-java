package com.test.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ben on 2017/7/12.
 */
public class _532KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        int length = nums.length;

        Arrays.sort(nums);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (nums[j] - nums[i] == k) {
                    set.add(nums[i] + "-" + nums[j]);
                    break;
                } else if (nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return set.size();
    }

    public int findPairs1(int[] nums, int k) {
        if (null == nums || nums.length < 1) {
            return 0;
        }
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums) {
            if (!set1.add(i)) {
                set2.add(i);
            }
        }
        if (k == 0) {
            return set2.size();
        }

        int length = set1.size();
        Integer[] sorted = new Integer[length];
        set1.toArray(sorted);

        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sorted[j] - sorted[i] == k) {
                    count++;
                    break;
                } else if (sorted[j] - sorted[i] > k) {
                    break;
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 1; i < nums.length; i++) {
            j = Math.max(j, i + 1);
            while (j < nums.length && nums[j] < nums[i] + k) {
                j++;
            }
            if (j < nums.length && nums[j] == nums[i] + k) {
                count++;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return count;
    }

    public int findPairs3(int[] nums, int k) {
        if (nums.length < 2 || k < 0) return 0;
        int cnt = 0;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> dups = new HashSet<Integer>();

        for (int i : nums) {
            if (k == 0) {
                if (!set.add(i)) {
                    if (dups.add(i))
                        cnt++;
                }
            } else {
                if (set.add(i)) {
                    if (set.contains(i - k)) cnt++;
                    if (set.contains(i + k)) cnt++;
                }
            }
        }
        return cnt;
    }
}
