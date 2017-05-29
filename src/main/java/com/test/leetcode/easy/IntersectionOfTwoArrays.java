package com.test.leetcode.easy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ben on 2017/5/29.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums2){
            set1.add(n);
        }
        Set<Integer> result = new HashSet<>();
        for (int n : set1) {
            if (set.add(n) == false) {
                result.add(n);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int n : result) {
            res[i++] = n;
        }
        return res;
    }
}
