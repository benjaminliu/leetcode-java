package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/23.
 */
public class _408_ValidWordAbbreviation {

    //Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
    //A string such as “word” contains only the following valid abbreviations:

    //   [“word”, “1ord”, “w1rd”, “wo1d”, “wor1”, “2rd”, “w2d”, “wo2”, “1o1d”, “1or1”, “w1r1”, “1o2”, “2r1”, “3d”, “w3”, “4”]

    //Notice that only the above abbreviations are valid abbreviations of the string “word”.
    //Any other string is not a valid abbreviation of “word”.

    //Note:
    //Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || word.length() == 0) {
            if (abbr == null || abbr.length() == 0) {
                return true;
            }
            return false;
        }
        int len = word.length();
        int len2 = abbr.length();
        if (len < len2) return false;

        int idx = 0;
        char c1, c2;
        int n;
        for (int i = 0; i < len; i++) {
            if (idx == len2) return false;
            c1 = word.charAt(i);
            c2 = abbr.charAt(idx);
            if (c1 == c2) {
                idx++;
                continue;
            }
            //c2 is num
            if (c2 >= '0' && c2 <= '9') {
                n = c2 - '0';
                while (n > 0) {
                    i++;
                }
                idx++;
                continue;
            }
            return false;
        }
        return true;
    }
}
