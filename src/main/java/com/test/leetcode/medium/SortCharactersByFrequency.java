package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/5/20.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        char[] cs = s.toCharArray();
        int max = 1;
        int temp;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            temp = map.get(c) + 1;
            map.put(c, temp);
            max = Math.max(max, temp);
        }

        List<List<Character>> ll = new ArrayList<>(max + 1);
        for (int i = 0, length = max + 1; i < length; i++) {
            ll.add(new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ll.get(entry.getValue()).add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = ll.size() - 1; i > 0; i--) {
            for (int j = ll.get(i).size() - 1; j >= 0; j--) {
                for (int z = i; z > 0; z--) {
                    sb.append(ll.get(i).get(j));
                }
            }
        }
        return sb.toString();
    }

    //TreeMap is ordered by nature
    public String frequencySort1(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        int[] a = new int[256];

        for (char c : s.toCharArray())
            a[c]++;

        TreeMap<Integer, String> map = new TreeMap<>();
        for(int i = 0; i < 256; i++) {
            if(a[i] > 0) {
                String ss = map.getOrDefault(a[i], "");
                map.put(a[i], ss + (char)i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(map.size() > 0) {
            Map.Entry<Integer, String> entry = map.pollLastEntry();
            for(char c : entry.getValue().toCharArray()) {
                for(int i = 0 ; i < entry.getKey(); i++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }

}
