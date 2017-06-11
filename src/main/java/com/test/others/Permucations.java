package com.test.others;

/**
 * Created by ben on 2017/6/11.
 */
public class Permucations {
    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private final String in;

    public Permucations(final String str) {
        in = str;
        used = new boolean[in.length()];
    }

    public void permute() {
        if (out.length() == in.length()) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i < in.length(); i++) {
            if (used[i]) {
                continue;
            }
            out.append(in.charAt(i));
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }
}
