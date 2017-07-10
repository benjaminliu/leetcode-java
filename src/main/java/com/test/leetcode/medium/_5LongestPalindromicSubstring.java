package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/9.
 */
public class _5LongestPalindromicSubstring {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 1; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    //��̬�滮�㷨
    public String longestPalindrome1(String s1) {
        char[] s = s1.toCharArray();
        int strLen = s.length;
        int begin = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[strLen][strLen];
        //ǰ�ڵĳ�ʼ��1: ������һ���ַ�Ҳ�ǻ��İ�
        for (int i = 0; i < strLen; i++) {
            table[i][i] = true;
        }
        //ǰ�ڵĳ�ʼ��2��������ȵ������ַ���ȻҲ��
        for (int i = 0; i < strLen - 1; i++) {
            if (s[i] == s[i + 1]) {
                table[i][i + 1] = true;
                begin = i;
                maxLen = 2;
            }
        }
        //����3��Ѱ�ҳ���Ϊ3�������ϵĻ����Ӵ�
        for (int len = 3; len <= strLen; len++) //��ǰ�Ӵ��ĳ���len
        {
            for (int i = 0; i < strLen - len + 1; i++) //��ǰ�Ӵ���ʼλ��i
            {
                int j = i + len - 1; //�Ӵ�ĩβλ��j     --��j-i=len-1
                if (s[i] == s[j] && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    begin = i;
                    maxLen = len;
                }
            }
        }
        return s1.substring(begin, begin + maxLen);
    }
}
