package com.test.leetcode.easy;

import java.util.*;

/**
 * Created by ben on 2017/5/31.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2 || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            int i = map.getOrDefault(n, 0);
            map.put(n, i + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            int i = map.getOrDefault(n, 0);
            if (i > 0) {
                result.add(n);
                map.put(n, i - 1);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int n : result) {
            res[i++] = n;
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] res = new int[nums1.length];
        int index = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
