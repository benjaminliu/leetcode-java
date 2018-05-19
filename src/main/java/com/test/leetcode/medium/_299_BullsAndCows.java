package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/10/31.
 */
public class _299_BullsAndCows {
    public String getHint(String secret, String guess) {
        Integer[] map = new Integer[10];
        int cow = 0;
        int bull = 0;
        char c1, c2;
        int i1, i2;

        int idx = 0;
        while (idx < secret.length()) {
            c1 = secret.charAt(idx);
            c2 = guess.charAt(idx);
            if (c1 == c2)
                cow++;
            else {
                i1 = c1 - '0';
                if (null == map[i1])
                    map[i1] = 1;
                else {
                    if (map[i1] < 0)
                        bull++;
                    map[i1]++;
                }


                i2 = c2 - '0';
                if (null == map[i2])
                    map[i2] = -1;
                else {
                    if (map[i2] > 0)
                        bull++;
                    map[i2]--;
                }
            }
            idx++;
        }

        return "" + cow + "A" + bull + "B";
    }

    public String getHint1(String secret, String guess) {
        int bulls = 0, cows = 0;
        char[] secretCharArr = secret.toCharArray();
        char[] guessCharArr = guess.toCharArray();
        int[] secretNumberArray = new int[10];
        int[] guessNumberArray = new int[10];
        for (int i = 0; i < secretCharArr.length; i++) {
            if (secretCharArr[i] == guessCharArr[i]) bulls++;
            else {
                secretNumberArray[secretCharArr[i] - '0']++;
                guessNumberArray[guessCharArr[i] - '0']++;
            }
        }
        for (int i = 0; i < secretNumberArray.length && bulls != secretCharArr.length; i++) {
            if (secretNumberArray[i] > 0 && guessNumberArray[i] > 0) {
                cows += Math.min(secretNumberArray[i], guessNumberArray[i]);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
