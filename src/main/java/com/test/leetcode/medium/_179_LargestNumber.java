package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/10/18.
 */
public class _179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for (int i = strs.length - 1; i > -1; i--) {
            sb.append(strs[i]);
        }

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
