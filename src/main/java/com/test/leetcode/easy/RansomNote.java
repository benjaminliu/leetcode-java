package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/5/29.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (null == ransomNote || null == magazine) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int i = map.getOrDefault(c, 0);
            map.put(c, i + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int i = map.getOrDefault(c, 0);
            if (i < 1) {
                return false;
            }
            map.put(c, i - 1);
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--table[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
