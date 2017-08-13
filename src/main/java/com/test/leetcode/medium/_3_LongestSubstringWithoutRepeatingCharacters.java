package com.test.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ben on 2017/6/12.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        int proLocation = 1;
        int aftLocation = 1;
        int[] c = new int['~' - ' ' + 1];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (c[a - ' '] >= proLocation) {
                maxLength = maxLength < aftLocation - proLocation + 1 ? aftLocation - proLocation + 1 : maxLength;
                proLocation = c[a - ' '] + 1;
            }
            c[a - ' '] = i + 1;
            aftLocation = c[a - ' '];
        }
        maxLength = maxLength < aftLocation - proLocation + 1 ? aftLocation - proLocation + 1 : maxLength;
        return maxLength;
    }

    //find the max distance of 2 duplication char
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int max = 0;
        int[] dp = new int[256];
        Arrays.fill(dp, -1);
        int j = -1;
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i);
            if (dp[c] > j) {
                max = Math.max(i - j - 1, max);
                j = dp[c];
            }
            dp[c] = i;
        }
        max = Math.max(len - j - 1, max);
        return max;
    }
}
