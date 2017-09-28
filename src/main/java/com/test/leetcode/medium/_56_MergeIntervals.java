package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ben on 2017/9/1.
 */
public class _56_MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (null == intervals || intervals.size() == 0) return res;
        if (intervals.size() == 1) return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval temp = new Interval();
        temp.start = intervals.get(0).start;
        temp.end = intervals.get(0).end;

        Interval cur;
        for (int i = 1; i < intervals.size(); i++) {
            cur = intervals.get(i);
            if (cur.start <= temp.end) {
                if (temp.end < cur.end) {
                    temp.end = cur.end;
                }
            } else {
                res.add(temp);
                temp = new Interval();
                temp.start = cur.start;
                temp.end = cur.end;
            }
        }
        res.add(temp);
        return res;
    }
}
