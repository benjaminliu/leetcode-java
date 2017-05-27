package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if ('Z' - c >= 0) count++;
        }

        return (count == 0 || count == word.length()) || (count == 1 && 'Z' - word.charAt(0) >= 0);
    }
}
