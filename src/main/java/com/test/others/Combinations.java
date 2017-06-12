package com.test.others;

/**
 * Created by ben on 2017/6/11.
 */
public class Combinations {
    private StringBuilder out = new StringBuilder();
    private final String in;

    public Combinations(final String str) {
        in = str;
    }

    public void combine() {
        combine(0);
    }

    private void combine(int start) {
        for (int i = start; i < in.length(); i++) {
            out.append(in.charAt(i));
            System.out.println(out);
            if (i < in.length()) {
                combine(i + 1);
            }
            out.setLength(out.length() - 1);
        }
    }

    //loop partitioning
    //the if removed from loop is called loop index dependent conditionals
    private void combine1(int start) {
        for (int i = start; i < in.length() - 1; i++) {
            out.append(in.charAt(i));
            System.out.println(out);
            combine1(i + 1);
            out.setLength(out.length() - 1);
        }
        out.append(in.charAt(in.length() - 1));
        System.out.println(out);
        out.setLength(out.length() - 1);
    }
}
