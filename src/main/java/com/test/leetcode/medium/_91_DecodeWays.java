package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/18.
 */
public class _91_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] sa = s.toCharArray();
        int[] dp = new int[sa.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= sa.length; i++) {
            if (sa[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && sa[i - 2] == '1') {
                dp[i] += dp[i - 2];
            }
            if (i > 1 && sa[i - 2] == '2' && sa[i - 1] <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[sa.length];
    }
}
