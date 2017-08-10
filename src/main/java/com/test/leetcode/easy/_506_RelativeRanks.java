package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/9.
 */
public class _506_RelativeRanks {
    public String[] relativeRanks(int[] scores) {
        if (null == scores || scores.length == 0) return new String[0];

        String[] map = new String[10001];
        for (int i = 0; i < scores.length; i++) {
            map[scores[i]] = "a";
        }

        int rank = 1;
        for (int i = 10000; i >= 0; i--) {
            if (map[i] == "a") {
                switch (rank) {
                    case 1:
                        map[i] = "Gold Medal";
                        break;
                    case 2:
                        map[i] = "Silver Medal";
                        break;
                    case 3:
                        map[i] = "Bronze Medal";
                    default:
                        map[i] = String.valueOf(rank);
                        break;
                }
                rank++;
            }
        }
        String[] result = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            result[i] = map[scores[i]];
        }
        return result;
    }
}
