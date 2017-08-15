package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/8/15.
 */
public class _659_SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        Map<Integer, Integer> append = new HashMap<>();

        for (int i : nums) {
            numCounts.put(i, numCounts.getOrDefault(i, 0) + 1);
        }

        //We iterate through the array once more and for each element we either see if it
        // can be appended to a previously constructed consecutive sequence
        // or if it can be the start of a new consecutive sequence.
        // If neither are true, then we return false.
        for (int i : nums) {
            if (numCounts.get(i) == 0) continue;

            else if (append.getOrDefault(i, 0) > 0) {
                //check if i is valid,
                // valid means there is a sequence include i-3, i-2, i-1 exits
                // if i is valid, next valid num is i+1
                append.put(i, append.get(i) - 1);
                append.put(i + 1, append.getOrDefault(i + 1, 0) + 1);
            } else if (numCounts.getOrDefault(i + 1, 0) > 0 && numCounts.getOrDefault(i + 2, 0) > 0) {
                //there is no valid sequence exist, so check if we can form a new valid sequence
                numCounts.put(i + 1, numCounts.get(i + 1) - 1);
                numCounts.put(i + 2, numCounts.get(i + 2) - 1);
                // i, i+1, i+2 are 3 consecutive integers, the next valid num is i+3,
                // so we add i+3 to map,
                // if i+3 appears, we know it is valid
                append.put(i + 3, append.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }

            numCounts.put(i, numCounts.get(i) - 1);
        }
        return true;
    }
}
