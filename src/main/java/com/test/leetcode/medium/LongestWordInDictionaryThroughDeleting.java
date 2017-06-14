package com.test.leetcode.medium;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ben on 2017/6/13.
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null) {
            return "";
        }

        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o2.length() - o1.length();
                if (result == 0) {
                    return o2.compareTo(o1);
                }
                return result;
            }
        });
        int di;
        int si;
        for (String d1 : d) {
            si = 0;
            di = 0;

            while (si < s.length()) {
                if (d1.charAt(di) == s.charAt(si++)) {
                    di++;
                }
                if (di == d1.length()) {
                    return d1;
                }
            }
        }
        return "";
    }


    public String findLongestWord1(String s, List<String> d) {

        int max = 0;
        String str = "";
        for (String st : d) {
            int len = st.length();
            if (len < max) {
                continue;
            }
            boolean isFound = getSub(s, st);

            if (!isFound) {
                continue;
            }
            //   System.out.println(st);
            int prevmax = max;
            max = Math.max(st.length(), max);

            if (max == prevmax) {
                str = compare(str, st);
            } else {
                str = st;
            }
        }
        return str;
    }

    String compare(String s1, String s2) {
        if (s1 == "") {
            return s2;
        }

        if (s1.compareTo(s2) < 0) {
            return s1;
        } else {
            return s2;
        }
    }

    boolean getSub(String s, String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {

            index = s.indexOf(str.charAt(i), index);

            if (index == -1) {
                return false;
            }
            index++;
        }
        return true;
    }


    public String findLongestWord2(String s, List<String> d) {
        String longestWord = "";
        for (String element : d) {
            if (isSubString(s, element)) {
                if (element.length() > longestWord.length()) {
                    longestWord = element;
                } else if (element.length() == longestWord.length() &&
                        element.compareTo(longestWord) < 0) {
                    longestWord = element;
                }
            }
        }
        return longestWord;
    }

    // search d in s
    private boolean isSubString(String s, String d) {
        if (d.length() > s.length()) return false;
        if (d.length() == s.length()) return s.equals(d);

        int lo = 0;
        for (int i = 0; i < d.length(); ++i) {
            // there is not enough character in s
            if (s.length() - lo < d.length() - i) return false;

            lo = s.indexOf(d.charAt(i), lo);
            if (-1 == lo) return false;
            ++lo;
        }
        return true;
    }
}
