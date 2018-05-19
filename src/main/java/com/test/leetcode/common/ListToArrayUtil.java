package com.test.leetcode.common;

import java.util.List;

/**
 * Created by ben on 2017/11/10.
 */
public class ListToArrayUtil {
    public static Integer[] intListToArray(List<Integer> list) {
        if (null == list)
            return null;
        return list.stream().toArray(Integer[]::new);
    }
}
