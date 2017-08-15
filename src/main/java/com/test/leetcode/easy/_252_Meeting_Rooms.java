package com.test.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ben on 2017/8/15.
 */
public class _252_Meeting_Rooms {

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

    //Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // determine if a person could attend all meetings.

    //For example,
    //Given [[0, 30],[5, 10],[15, 20]],
    //        return false.

    public boolean canAttendMeetings(Interval[] intervals) {
        if (null == intervals || intervals.length < 2) return true;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
