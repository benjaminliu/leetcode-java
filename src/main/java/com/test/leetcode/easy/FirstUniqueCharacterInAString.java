package com.test.leetcode.easy;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ben on 2017/5/29.
 */
public class FirstUniqueCharacterInAString {
    public class Node {
        public int count;
        public int index;
    }

    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, Node> map = new LinkedHashMap<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            Node i = map.get(c);
            if (null == i) {
                i = new Node();
                i.index = index;
            }
            i.count++;
            map.put(c, i);
            index++;
        }

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Node> entry = (Map.Entry) iter.next();
            if (entry.getValue().count == 1) {
                return entry.getValue().index;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int index = Integer.MAX_VALUE;
        int pos;
        for (int i = 97; i <= 122; i++) {
            pos = s.indexOf(i);
            if (pos != -1 && pos == s.lastIndexOf(i)) {
                index = pos < index ? pos : index;
            }
        }
        if (index != Integer.MAX_VALUE) {
            return index;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] alp = new int[26 + 'a'];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            alp[c]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (alp[arr[i]] == 1) return i;
        }

        return -1;

    }
}
