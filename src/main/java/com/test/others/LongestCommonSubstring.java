package com.test.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/6/2.
 */
public class LongestCommonSubstring {

    public List<String> getLongestCommonSubstring(String str1, String str2) {
        int[][] arr = new int[str1.length()][str2.length()];
        List<String> lcs = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                        lcs.clear();
                        lcs.add(str1.substring(i - max + 1, i + 1));
                    } else if (max == arr[i][j]) {
                        lcs.add(str1.substring(i - max + 1, i + 1));
                    }
                }
            }
        }

        return lcs;
    }
}
