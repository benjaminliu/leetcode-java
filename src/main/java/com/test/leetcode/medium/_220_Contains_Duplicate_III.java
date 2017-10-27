package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by ben on 2017/10/25.
 */
public class _220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //input check
        if (k < 1 || t < 0 || nums == null || nums.length < 2) return false;

        SortedSet<Long> set = new TreeSet<Long>();

        for (int j = 0; j < nums.length; j++) {
            SortedSet<Long> subSet = set.subSet((long) nums[j] - t, (long) nums[j] + t + 1);
            if (!subSet.isEmpty()) return true;

            if (j >= k) {
                set.remove((long) nums[j - k]);
            }
            set.add((long) nums[j]);
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (t < 0 || k < 1)
            return false;
        long w = (long) t + 1;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int bucket = getId((long) nums[i], w);
            if (map.containsKey(bucket))
                return true;
            if (map.containsKey(bucket + 1) && map.get(bucket + 1) - nums[i] < w)
                return true;
            if (map.containsKey(bucket - 1) && nums[i] - map.get(bucket - 1) < w)
                return true;
            map.put(bucket, (long) nums[i]);
            if (i >= k) map.remove(getId(nums[i - k], w));
        }
        return false;
    }

    private int getId(long n, long w) {
        if (n < 0) return (int) ((n + 1) / w - 1);
        else return (int) (n / w);
    }
}
