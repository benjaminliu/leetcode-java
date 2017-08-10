package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/10.
 */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (int n : nums) {
            int i = map.getOrDefault(n, 0);
            i++;
            if (i > half) {
                return n;
            }
            map.put(n, i);
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int major = nums[0], count = 0;
        for (int val : nums) {
            if (count == 0) {
                major = val;
            }

            if (major == val) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    //每次找一对不同的数，删除，最后留下来的，肯定是大于1半的数
    public int majorityElement2(int[] nums) {
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
