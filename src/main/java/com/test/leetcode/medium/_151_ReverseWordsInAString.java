package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/17.
 */
public class _151_ReverseWordsInAString {
    public String reverseWords1(String s) {
        if (null == s || s.length() <= 1) return s;

        char[] cs = s.toCharArray();
        int len = cs.length;
        int start = 0, end = len - 1;
        reverse(cs, start, end);

        start = 0;
        for (int i = 0; i < len; i++) {
            if (cs[i] == ' ') {
                reverse(cs, start, i - 1);
                start = i + 1;
            }
        }
        end  = len-1;
        reverse1(cs, start, end);

        cleanSpaces(cs,len);

        return new String(cs);
    }

    private void reverse1(char[] cs, int start, int end) {

        while (start < end) {
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }



    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            if (sb.length() == 0) {
                sb.append(strs[i]);
            } else {
                sb.append(" ").append(strs[i]);
            }
        }
        return sb.toString();
    }
    private void swap(char[] s, int i, int j) {
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
