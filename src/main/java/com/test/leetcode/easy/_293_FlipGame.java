package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/16.
 */
public class _293_FlipGame {

    //You are playing the following Flip Game with your friend:
    // Given a string that contains only these two characters: + and -,
    // you and your friend take turns to flip two consecutive "++" into "--".
    // The game ends when a person can no longer make a move and therefore the other person will be the winner.

    //Write a function to compute all possible states of the string after one valid move.
    //For example, given s = "++++", after one move, it may become one of the following states:

    //        [
    //        "--++",
    //        "+--+",
    //        "++--"
    //        ]
    //If there is no valid move, return an empty list [].

    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() < 2) return results;

        final char plus = '+';
        final char minus = '-';

        char[] cs = s.toCharArray();
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (cs[i] == cs[i - 1]) {
                if (cs[i] == plus) {
                    cs[i] = minus;
                    cs[i - 1] = minus;
                    results.add(new String(cs));
                    cs[i] = plus;
                    cs[i - 1] = plus;
                } else {
                    cs[i] = plus;
                    cs[i - 1] = plus;
                    results.add(new String(cs));
                    cs[i] = minus;
                    cs[i - 1] = minus;
                }
            }
        }
        return results;
    }

    public List<String> generatePossibleNextMoves1(String s) {
        List<String> results = new ArrayList<>();
        char[] sa = s.toCharArray();
        for (int i = 0; i < sa.length - 1; i++) {
            if (sa[i] == '+' && sa[i + 1] == '+') {
                sa[i] = '-';
                sa[i + 1] = '-';
                results.add(new String(sa));
                sa[i] = '+';
                sa[i + 1] = '+';
            }
        }
        return results;
    }
}
