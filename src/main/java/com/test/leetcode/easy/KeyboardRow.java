package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/5/15.
 */
public class KeyboardRow {
    private char[] firstRow = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
    private char[] secondRow = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
    private char[] thirdRow = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        List<String> result = new ArrayList<String>(words.length);
        int firstMatch;
        int secondMatch;
        int thirdMatch;
        int length;
        char tempC;
        String tempS;
        for (String word : words) {
            if (word == null || word.length() == 0) {
                break;
            }
            firstMatch = 0;
            secondMatch = 0;
            thirdMatch = 0;
            length = word.length();
            tempS = word.toLowerCase();

            for (int i = 0; i < length; i++) {
                tempC = tempS.charAt(i);
                if (firstRowContains(tempC)) {
                    firstMatch++;
                } else if (secondRowContains(tempC)) {
                    secondMatch++;
                } else if (thirdRowContains(tempC)) {
                    thirdMatch++;
                } else {
                    throw new IllegalArgumentException("Input contains not only char");
                }
            }
            if (firstMatch == length || secondMatch == length || thirdMatch == length) {
                result.add(word);
            }
        }
        String[] ss = new String[result.size()];
        return result.toArray(ss);
    }

    private boolean firstRowContains(char c) {
        return arrayContains(firstRow, c);
    }

    private boolean secondRowContains(char c) {
        return arrayContains(secondRow, c);
    }

    private boolean thirdRowContains(char c) {
        return arrayContains(thirdRow, c);
    }

    private boolean arrayContains(char[] cs, char c) {
        for (char i : cs) {
            if (i == c) {
                return true;
            }
        }
        return false;
    }
}
