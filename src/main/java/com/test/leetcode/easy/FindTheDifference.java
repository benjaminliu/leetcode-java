package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ben on 2017/5/27.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if (null == s) {
            return t.charAt(0);
        }
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int count;
        for (char c : s.toCharArray()) {
            count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char c : t.toCharArray()) {
            count = map.getOrDefault(c, 0);
            if (count == 0) {
                return c;
            }
            map.put(c, count - 1);
        }
        return '0';
    }

    public char findTheDifference2(String s, String t) {
        char diff = '1';

        for (char c : s.toCharArray()) {
            diff ^= c;
        }

        for (char c : t.toCharArray()) {
            diff ^= c;
        }
        diff ^= '1';
        return diff;
    }
}
