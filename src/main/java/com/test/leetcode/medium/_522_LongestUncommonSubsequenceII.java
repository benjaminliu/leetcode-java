package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/7.
 */
public class _522_LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int ret = -1;
        label:
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= ret) continue;
            int j = 0;
            for (; j < strs.length; j++) {
                if (j == i) continue;
                if (isSubsequence(strs[i], strs[j])) continue label;
            }
            if (strs[i].length() > ret) ret = strs[i].length();
        }
        return ret;
    }

    public boolean isSubsequence(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.length() == s2.length()) return s1.equals(s2);
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        int j = 0;
        for (int i = 0; i < chars2.length && j < chars1.length; i++) {
            if (chars1[j] == chars2[i]) j++;
        }
        return j == chars1.length;
    }


    public int findLUSlength1(String[] strs) {
        int ret = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence1(strs[i], strs[j])) break;
            }
            if (j == strs.length) ret = Math.max(ret, strs[i].length());
        }
        return ret;
    }


    public boolean isSubsequence1(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
}
