package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/18.
 */
public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> tmp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++)
            list.add(i ^ (i >> 1));
        return list;
    }

}
