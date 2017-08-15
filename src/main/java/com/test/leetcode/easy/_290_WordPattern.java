package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/15.
 */
public class _290_WordPattern {

    //To improve, we don't need map, only need 2 int to store last position or first position
    public boolean wordPattern(String pattern, String str) {
        if (null == pattern || null == str) return false;

        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        Map<Character, Integer> cmap = new HashMap<>();
        Map<String, Integer> smap = new HashMap<>();
        int ci, si;
        for (int i = 0; i < pattern.length(); i++) {
            ci = cmap.getOrDefault(pattern.charAt(i), -1);
            si = smap.getOrDefault(strs[i], -1);
            if (ci != si) return false;
            cmap.put(pattern.charAt(i), i);
            smap.put(strs[i], i);
        }
        return true;
    }
}
