package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/1.
 */
public class _647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    String sub = s.substring(j, i + 1);
                    if (isPalindromic(sub)) {
                        temp++;
                    }
                }
            }
            dp[i] = dp[i - 1] + temp;
        }
        return dp[len - 1] + len;
    }

    private boolean isPalindromic(String sub) {
        int len = sub.length();
        for (int i = 0; i < len / 2; i++) {
            if (sub.charAt(i) != sub.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    int count = 0;

    public int countSubstrings1(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return count;
    }

    private void helper(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}
