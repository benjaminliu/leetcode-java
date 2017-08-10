package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/12.
 */
public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = strs.length;
        String prefix = commonPrefix(strs, 0, length - 1);
        return prefix;
    }

    private String commonPrefix(String[] strs, int start, int end) {
        if (start < end) {
            if (start == end - 1) {
                return prefixOfTwo(strs[start], strs[end]);
            } else {
                int mid = (start + end) / 2;
                String leftPrefix = commonPrefix(strs, start, mid);
                String rightPrefix = commonPrefix(strs, mid + 1, end);
                return prefixOfTwo(leftPrefix, rightPrefix);
            }
        }
        return strs[start];
    }

    private String prefixOfTwo(String leftPrefix, String rightPrefix) {
        if (leftPrefix == null || leftPrefix == "") {
            return "";
        }
        if (rightPrefix == null || rightPrefix == "") {
            return "";
        }
        int index = 0;
        int max = Math.min(leftPrefix.length(), rightPrefix.length());
        while (index < max) {
            if (leftPrefix.charAt(index) != rightPrefix.charAt(index)) {
                break;
            }
            index++;
        }
        if (index == 0) {
            return "";
        }
        return leftPrefix.substring(0, index);
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String currentLongestPrefix = strs[0];
        for (String s : strs) {
            // int currentLongestPrefixLen = currentLongestPrefix.length();
            while (s.indexOf(currentLongestPrefix) != 0 && currentLongestPrefix.length() > 0) {
                currentLongestPrefix = currentLongestPrefix.substring(0, currentLongestPrefix.length() - 1);
            }
        }

        return currentLongestPrefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            int max = Math.min(prefix.length(), str.length);
            int j = 0;
            for (; j < max && prefix.charAt(j) == str[j]; j++) {
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String left = strs[0];
        String right;
        int length = strs.length;
        for (int i = 1; i < length; i++) {
            right = strs[i];
            left = prefixOfTwo(left, right);
            if (left.length() == 0) {
                return "";
            }
        }
        return left;
    }
}
