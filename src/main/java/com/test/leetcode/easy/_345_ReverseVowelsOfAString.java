package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/17.
 */
public class _345_ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);

        char[] cs = s.toCharArray();
        char temp;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && map.get(cs[start]) == null) {
                start++;
            }
            while (start < end && map.get(cs[end]) == null) {
                end--;
            }
            temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }

        return new String(cs);
    }
}
