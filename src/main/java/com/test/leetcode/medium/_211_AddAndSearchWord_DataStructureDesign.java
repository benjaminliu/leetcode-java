package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/10/24.
 */
public class _211_AddAndSearchWord_DataStructureDesign {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public _211_AddAndSearchWord_DataStructureDesign() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;
        return isMatch(word, 0, node);
    }

    private boolean isMatch(String word, int idx, TrieNode node) {
        if (word.length() == idx) {
            return node.isEnd;
        }

        if (word.charAt(idx) != '.') {
            return node.next[word.charAt(idx) - 'a'] != null && isMatch(word, idx + 1, node.next[word.charAt(idx) - 'a']);
        }

        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null && isMatch(word, idx + 1, node.next[i])) {
                return true;
            }
        }
        return false;
    }
}
