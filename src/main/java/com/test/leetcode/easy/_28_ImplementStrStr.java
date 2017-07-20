package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/18.
 */
public class _28_ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        long sum = 0;
        for (char c : needle.toCharArray()) {
            sum += (int) c;
        }

        long tempSum = 0;
        for (int i = 0; i < needle.length() - 1; i++) {
            tempSum += (int) haystack.charAt(i);
        }
        int lastIdx = -1;
        int tempIdx;
        boolean found = false;
        char tempChar;
        for (int i = needle.length() - 1; i < haystack.length(); i++) {
            if (lastIdx >= 0) {
                tempChar = haystack.charAt(lastIdx);
                tempSum -= tempChar;
            }
            lastIdx++;
            tempChar = haystack.charAt(i);
            tempSum += tempChar;

            if (tempSum == sum) {
                tempIdx = lastIdx;
                found = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(tempIdx++) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return lastIdx;
                }
            }
        }
        return -1;
    }
}
