package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/5/29.
 */
public class MajorityElement {
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

    //Moore's voting algorithm
    //http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html#step01
    //
    //Group the nums into pairs,
    //make the pairs as different number as possible,
    //since there is one majority element,
    //every pair has one majority element as least
    //( as least one pair has two majority element, or there will be only one majority element left),
    //so we delete the pair one by one,
    //and at last, only majority element will remain.
    //In following code, count-- means we delete one pair,
    //when count is 0, the chosen number is not the majority element, so we change it to next number
    public int majorityElement1(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
