package com.test.leetcode.medium;

import com.test.leetcode.common.IntegerUtils;

import java.util.*;

/**
 * Created by ben on 2017/8/11.
 */
public class _49_GroupAnagrams {
    private final char Zero = 'a';

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (null == strs || strs.length == 0) {
            return result;
        }
        List<String> l;
        if (strs.length == 1) {
            l = new ArrayList<>();
            l.add(strs[0]);
            result.add(l);
            return result;
        }

        long sum;
        Map<Long, List<String>> map = new HashMap<>();
        Map<Long, List<String>> special = new HashMap<>();

        for (String s : strs) {
            sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - Zero;
            }
            l = map.getOrDefault(sum, new ArrayList<>());
            if (l.size() == 0) {
                l.add(s);
                map.put(sum, l);
            } else if (!isAnagrams(l.get(0), s)) {
                List<String> d = special.getOrDefault(sum, new ArrayList<>());
                d.add(s);
                special.put(sum, d);
            } else {
                l.add(s);
                map.put(sum, l);
            }
        }

        if (special.size() > 0) {
            for (Map.Entry<Long, List<String>> entry : special.entrySet()) {
                List<String> temp = entry.getValue();
                temp.addAll(map.remove(entry.getKey()));
                List<List<String>> lls = new ArrayList<>();
                lls.add(new ArrayList<>());
                lls.get(0).add(temp.get(0));
                boolean found;
                String s;
                for (int i = 1; i < temp.size(); i++) {
                    found = false;
                    s = temp.get(i);
                    for (List<String> ls : lls) {
                        if (isAnagrams(ls.get(0), s)) {
                            ls.add(temp.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (found == false) {
                        List<String> t1 = new ArrayList<>();
                        t1.add(s);
                        lls.add(t1);
                    }
                }

                for (List<String> ls : lls) {
                    result.add(ls);
                }
            }
        }

        for (List<String> ls : map.values()) {
            result.add(ls);
        }
        return result;
    }

    private boolean isAnagrams(String s, String s1) {
        if (s.length() != s1.length()) {
            return false;
        }
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - Zero]++;
        }
        for (char c : s1.toCharArray()) {
            map[c - Zero]--;
            if (map[c - Zero] < 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
