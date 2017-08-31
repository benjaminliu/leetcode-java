package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _657_JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if (null == moves || moves.length() == 0) return true;
        if (moves.length() % 2 == 1) return false;

        int[] position = new int[2];
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    position[0]++;
                    break;
                case 'D':
                    position[0]--;
                    break;
                case 'L':
                    position[1]++;
                    break;
                default:
                    position[1]--;
                    break;
            }
        }

        return position[0] == 0 && position[1] == 0;
    }
}
