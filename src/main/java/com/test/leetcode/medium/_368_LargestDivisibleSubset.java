package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_LargestDivisibleSubset {
   static class Solution {
        public static List<Integer> largestDivisibleSubset(int[] nums) {
            if (nums.length == 0) return new ArrayList<Integer>();
            //sort the array first
            Arrays.sort(nums);
            ArrayList<Integer>[] dp = (ArrayList<Integer>[]) new ArrayList[nums.length];
            int maxindex = 0;
            int maxsize = -1;
            int finalindex = 0;
            int finalsize = -1;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = new ArrayList<Integer>();
                for (int j = i-1; j >= 0; j--) {
                    //if nums[i] can be divided by nums[j], it can also be divided by every element in dp[j].
                    //Find a previous nums[j] that has most element in
                    if (nums[i] % nums[j] == 0) {
                        if (dp[j].size() > maxsize) {
                            maxsize = dp[j].size();
                            maxindex = j;
                        }
                    }
                }
                //if maxsize not equal to -1, which means divisor for nums[i] is found,
                //add the one with most element in.
                if (maxsize != -1) dp[i].addAll(dp[maxindex]);
                //add nums[i] itself to dp
                dp[i].add(nums[i]);
                if (dp[i].size() > finalsize) {
                    finalsize = dp[i].size();
                    finalindex = i;
                }
                maxindex = 0;
                maxsize = -1;

            }
            return dp[finalindex];
        }
    }

    public static void main(String[] args) {
        System.out.println(  Solution.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
