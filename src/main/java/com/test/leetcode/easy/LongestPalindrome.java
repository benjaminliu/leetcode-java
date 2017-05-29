package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/5/29.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Boolean> map = new HashMap<>();
        int sum = 0;
        for (Character c : s.toCharArray()) {
            boolean b = map.getOrDefault(c, true);
            b = !b;
            if (b) {
                sum += 2;
            }
            map.put(c, b);
        }

        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue() == false) {
                sum++;
                break;
            }
        }
        return sum;
    }

    public int longestPalindrome1(String s) {
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
            if (!map[c]) len += 2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }

    public int longestPalindrome2(String s) {
        int[] lib = new int[52];
        for (char c : s.toCharArray()) {
            if (c <= 'Z' && c >= 'A')
                lib[c - 'A' + 26] += 1;
            else
                lib[c - 'a'] += 1;
        }
        int result = 0;
        int maxodd = 0;
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] % 2 == 0)
                result += lib[i];
            else {
                maxodd = 1;
                result += lib[i] - 1;
            }
        }
        return result + maxodd;
    }
}
