package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/10/18.
 */
public class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 11) return res;
        int hash = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> unique = new HashSet<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < 9) {
                hash = (hash << 2) + map.get(c);
            } else {
                hash = (hash << 2) + map.get(c);
                hash &= (1 << 20) - 1;
                if (set.contains(hash) && !unique.contains(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                    unique.add(hash);
                } else {
                    set.add(hash);
                }
            }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> answer = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();

        int l = s.length();
        for (int i = 0; i <= l - 10; i++) {
            String s1 = s.substring(i, i + 10);
            if (map.get(s1) != null && map.get(s1) == 1) {
                answer.add(s1);
                map.put(s1, 2);
            } else {
                if (map.get(s1) == null) {
                    map.put(s1, 1);
                }
            }
        }

        return answer;
    }
}
