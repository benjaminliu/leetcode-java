package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/24.
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
