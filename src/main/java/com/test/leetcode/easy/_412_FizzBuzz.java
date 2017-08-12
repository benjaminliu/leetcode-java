package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/12.
 */
public class _412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i / 3 * 3 == i && i / 5 * 5 == i) res.add("FizzBuzz");
            else if (i / 3 * 3 == i) res.add("Fizz");
            else if (i / 5 * 5 == i) res.add("Buzz");
            else res.add(Integer.toString(i));
        }
        return res;
    }

    public List<String> fizzBuzz1(int n) {
        List<String> holder = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                holder.add("FizzBuzz");
            } else if (i % 5 == 0) {
                holder.add("Buzz");
            } else if (i % 3 == 0) {
                holder.add("Fizz");
            } else {
                holder.add(String.valueOf(i));
            }
        }

        return holder;
    }
}
