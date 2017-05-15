package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/5/15.
 */
public class EncodeAndDecodeTinyURL {

    private static final String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PREFIX = "http://tinyurl.com/";
    private static final Integer PREFIX_COUNT = PREFIX.length();

    private static int COUNTER = 0;

    private Map<Integer, String> sToL = new HashMap<Integer, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shorturl = base10ToBase62(COUNTER);
        sToL.put(COUNTER, longUrl);
        COUNTER++;
        return PREFIX+ shorturl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.substring(PREFIX_COUNT);
        int n = base62ToBase10(code);
        return sToL.get(n);
    }

    private String base10ToBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() != 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    private int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;
    }

    private int convert(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
}
