package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/15.
 */
public class _537_ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        if (a == null || a.length() < 4) {
            throw new IllegalArgumentException("Illegal a");
        }
        if (b == null || b.length() < 4) {
            throw new IllegalArgumentException("Illegal b");
        }

        String[] as = a.split("\\+");
        if (as.length != 2) {
            throw new IllegalArgumentException("Illegal a");
        }
        String[] bs = b.split("\\+");
        if (bs.length != 2) {
            throw new IllegalArgumentException("Illegal b");
        }

        String ar = as[0];
        String ai = as[1].substring(0, as[1].length() - 1);
        String br = bs[0];
        String bi = bs[1].substring(0, bs[1].length() - 1);

        int intAr = Integer.parseInt(ar);
        int intAi = Integer.parseInt(ai);
        int intBr = Integer.parseInt(br);
        int intBi = Integer.parseInt(bi);

        int rr = intAr * intBr + (-1) * intAi * intBi;
        int ri = intAi * intBr + intBi * intAr;

        return String.valueOf(rr) + "+" + String.valueOf(ri) + "i";
    }
}
