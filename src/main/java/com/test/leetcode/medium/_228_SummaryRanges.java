package com.test.leetcode.medium;

import com.test.others.StringMatch_KMP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/10/26.
 */
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return res;
        }

        int start = 0;
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i - 1] + 1 < nums[i]) {
                if (i - start == 1) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    String temp = "" + nums[start] + "->" + (nums[i - 1]);
                    res.add(temp);
                }
                start = i;
            }
        }

        if (nums.length - start == 1) {
            res.add(String.valueOf(nums[start]));
        } else {
            String temp = "" + nums[start] + "->" + nums[nums.length - 1];
            res.add(temp);
        }

        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int s = nums[i++];
            while (i <= nums.length - 1 && nums[i] == nums[i - 1] + 1) i++;
            res.add(s == nums[i - 1] ? "" + s : s + "->" + nums[i - 1]);
        }
        return res;
    }
}
