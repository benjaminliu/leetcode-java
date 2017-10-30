package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/9/29.
 */
public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] words = new boolean[len];

        for (int i = 1; i <= len; i++) {
            int j;
            for (j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (wordDict.contains(sub) && (j == 0 || words[j - 1])) {
                    words[i - 1] = true;
                    break;
                }
            }
            if (j == i) {
                words[i - 1] = false;
            }
        }
        return words[len - 1];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        // HashSet dictionary for quick comparison
        int max = 0;
        int min = Integer.MAX_VALUE;
        HashSet<String> dict = new HashSet<String>();
        for (String word : wordDict) {
            dict.add(word);
            if (word.length() > max)
                max = word.length();
            if (word.length() < min)
                min = word.length();
        }

        // Trivial Case
        if (dict.contains(s))
            return true;

        // Easier Variable Names
        String word = s;
        int n = s.length();

        boolean[] prefixIsWords = new boolean[n];
        for (int i = min - 1; i < n; i++) {
            if (!prefixIsWords[i] && dict.contains(word.substring(0, i + 1)))
                prefixIsWords[i] = true;

            if (prefixIsWords[i]) {
                for (int j = i + min; j <= i + max + 1 && j < n; j++) {
                    if (!prefixIsWords[j] && dict.contains(word.substring(i + 1, j + 1)))
                        prefixIsWords[j] = true;

                    if (j == n - 1 && prefixIsWords[j]) // Last sub word is in wordDict
                        return true;
                }
            }
        }
        return false; // Word cannot be broken
    }


    //Example:
    //s = "leetcode"
    //words = ["leet", "code"]
    //d[3] is True because there is "leet" in the dictionary that ends at 3rd index of "leetcode"
    //d[7] is True because there is "code" in the dictionary that ends at the 7th index of "leetcode" AND d[3] is True

    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

}
