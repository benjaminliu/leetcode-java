package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/9/28.
 */
public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int length = 1;
        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String next = q.poll();
                for (String s : nextWords(next, wordSet)) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return length;
                    }
                    q.offer(s);
                    visited.add(s);
                }
            }
        }
        return 0;
    }

    private ArrayList<String> nextWords(String next, Set<String> wordSet) {
        ArrayList<String> result = new ArrayList<String>();
        if (wordSet == null || wordSet.size() == 0) {
            return result;
        }
        int n = next.length();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < n; i++) {
                if (c == next.charAt(i)) {
                    continue;
                }
                String newS = replace(next, c, i);
                if (wordSet.contains(newS)) {
                    result.add(newS);
                }
            }
        }
        return result;
    }

    private String replace(String s, char c, int index) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
