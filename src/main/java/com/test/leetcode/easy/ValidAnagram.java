package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/29.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }
        for(int n : map){
            if(n >0){
                return false;
            }
        }
        return true;
    }
}
