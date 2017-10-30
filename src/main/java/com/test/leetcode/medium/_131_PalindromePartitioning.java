package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/29.
 */
public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null) {
            return result;
        }
        if (s.length() == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        int len = s.length();
        char[] array = s.toCharArray();
        // isPal[i][j] represents if substring from index i to j is a palindrome string
        boolean[][] isPal = dpPalindrome(array, len);
        dfs(s, 0, isPal, new ArrayList<String>(), result);
        return result;
    }

    private boolean[][] dpPalindrome(char[] s, int len) {
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPal[i][i] = true;
            if (i < len - 1 && s[i] == s[i + 1]) isPal[i][i + 1] = true;
        }
        for (int size = 3; size <= len; size++) {
            for (int i = 0; i + size - 1 < len; i++) {
                int j = i + size - 1;
                isPal[i][j] = (s[i] == s[j]) && isPal[i + 1][j - 1];
            }
        }
        return isPal;
    }

    private void dfs(String s, int index, boolean[][] isPal, List<String> list, List<List<String>> res) {
        // base case
        int len = s.length();
        if (index == len) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = index; i < len; i++) {
            if (isPal[index][i]) {
                list.add(s.substring(index, i + 1));
                dfs(s, i + 1, isPal, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition1(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (cArray[i] == cArray[j] && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        List<List<String>> ll = new ArrayList<List<String>>();
        helper(dp, ll, new ArrayList<String>(), 0, s);
        return ll;
    }

    public void helper(boolean[][] dp, List<List<String>> ll, List<String> list, int pos, String s) {
        if (pos == dp.length) {
            ll.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos; i < dp.length; i++) {
            if (dp[pos][i]) {
                list.add(s.substring(pos, i + 1));
                helper(dp, ll, list, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }


    List<List<String>> resultLst;
    ArrayList<String> currLst;

    public List<List<String>> partition2(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s, 0);
        return resultLst;
    }

    public void backTrack(String s, int idx) {
        if (currLst.size() > 0 //the initial str could be palindrome
                && idx >= s.length()) {
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                if (idx == i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(idx, i + 1));
                backTrack(s, i + 1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static List<List<String>> partition3(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
