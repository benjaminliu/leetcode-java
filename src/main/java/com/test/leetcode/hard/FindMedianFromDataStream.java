package com.test.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ben on 2017/5/18.
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public FindMedianFromDataStream() {

    }

    public void addNum(int n) {
        if (n < findMedian()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        adust();
    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }

    private void adust() {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else {
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }
    }
}
