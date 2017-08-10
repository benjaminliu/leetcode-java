package com.test.leetcode.hard;

/**
 * Created by ben on 2017/8/7.
 */
public class _115_DistinctSubsequences {
    private int count = 0;

    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return 0;

        int lenS = s.length();
        int lenT = t.length();
        int diff = lenS - lenT;

        for (int i = 0; i <= diff; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                if (lenT == 1) {
                    count++;
                    continue;
                }
                helper(s.substring(i + 1), t.substring(1));
            }
        }
        return count;
    }

    private void helper(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return;
        }

        if (s.length() < t.length()) {
            return;
        }

        int diff = s.length() - t.length();
        for (int i = 0; i <= diff; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                if (1 == t.length()) {
                    count++;
                    continue;
                }
                helper(s.substring(i + 1), t.substring(1));
            }
        }
    }


    public int numDistinct1(String S, String T) {
        int[][] cnt = new int[T.length() + 1][S.length() + 1];
        for (int j = 0; j < S.length(); j++) {
            cnt[0][j] = 1;
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (T.charAt(i - 1) != S.charAt(j - 1)) {
                    cnt[i][j] = cnt[i][j - 1];    // The old way to match
                } else {    // Match, it allows us to have a new way to match
                    cnt[i][j] = cnt[i][j - 1] + cnt[i - 1][j - 1];    // old way + new way
                }
            }
        }

        return cnt[T.length()][S.length()];
    }
}
