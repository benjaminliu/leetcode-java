package com.test.leetcode.easy;

import java.util.PriorityQueue;

/**
 * Created by ben on 2017/8/23.
 */
public class _414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (pq.contains(i))
                continue;
            pq.add(i);
            if (pq.size() > 3) pq.poll();
        }
        if (pq.size() >= 3) return pq.poll();

        while (pq.size() > 1) pq.poll();
        return pq.poll();
    }
}
