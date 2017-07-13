package com.test.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/13.
 */
public class SumOfSequenceEqualsTarget {
    public List<List<Integer>> findSequences(int target) {
        if (target < 1) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        if (target == 1) {
            addSequece(result, 1, 1);
            return result;
        }

        int start = 1;
        int end = start + 1;
        int sum = start + end;
        int max = (target + 1) / 2;
        while (start < max) {
            if (sum == target) {
                addSequece(result, start, end);
                end++;
                sum += end;
            } else if (sum < target) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        return result;
    }

    private void addSequece(List<List<Integer>> result, int start, int end) {
        if (start <= end) {
            List<Integer> list = new ArrayList<>();
            while (start <= end) {
                list.add(start++);
            }
            result.add(list);
        }
    }
}
