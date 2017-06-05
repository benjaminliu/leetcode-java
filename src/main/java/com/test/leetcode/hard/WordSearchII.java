package com.test.leetcode.hard;

import java.util.*;

/**
 * Created by ben on 2017/6/2.
 */
public class WordSearchII {
    class Node {
        Node[] child;
        Node parent;
        int count;
        String s;

        public Node() {
            this.child = new Node[26];
            this.count = 0;
            this.parent = null;
            this.s = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        Node root = new Node();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < words.length; i++) {
            buildTrie(root, words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root.child[board[i][j] - 'a'], result, visited);
            }
        }
        return result;
    }

    public void search(char[][] board, int r, int c, Node curr, List<String> result, boolean[][] visited) {
        if (visited[r][c] || curr == null || curr.count == 0) {
            return;
        }
        visited[r][c] = true;
        if (curr != null && curr.s != null) {
            result.add(curr.s);
            curr.s = null;
            Node temp = curr;
            while (temp != null) {
                temp.count--;
                temp = temp.parent;
            }
        }
        if (r - 1 >= 0 && curr.child[board[r - 1][c] - 'a'] != null) {
            search(board, r - 1, c, curr.child[board[r - 1][c] - 'a'], result, visited);
        }
        if (r + 1 < board.length && curr.child[board[r + 1][c] - 'a'] != null) {
            search(board, r + 1, c, curr.child[board[r + 1][c] - 'a'], result, visited);
        }
        if (c - 1 >= 0 && curr.child[board[r][c - 1] - 'a'] != null) {
            search(board, r, c - 1, curr.child[board[r][c - 1] - 'a'], result, visited);
        }
        if (c + 1 < board[0].length && curr.child[board[r][c + 1] - 'a'] != null) {
            search(board, r, c + 1, curr.child[board[r][c + 1] - 'a'], result, visited);
        }
        visited[r][c] = false;
    }

    public void buildTrie(Node root, String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            curr.count++;
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
                curr.child[ch - 'a'].parent = curr;
            }
            curr = curr.child[ch - 'a'];
        }
        curr.count++;
        curr.s = s;
    }
}
