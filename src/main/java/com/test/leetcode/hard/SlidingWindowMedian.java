package com.test.leetcode.hard;

import java.util.*;

/**
 * Created by ben on 2017/5/18.
 */
public class SlidingWindowMedian {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("nums");
        }

        if (k < 1) {
            throw new IllegalArgumentException("k");
        }

        int index = 0;
        int length = nums.length;
        double[] results = new double[length - k + 1];
        int removeIndex;
        while (index < length) {
            if (index >= k) {
                removeIndex = index - k;
                results[removeIndex] = getMedium();
                remove(nums[removeIndex]);
            }

            //add
            add(nums[index]);

            index++;
        }
        results[index - k] = getMedium();

        return results;
    }

    private double getMedium() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }

    private void add(int n) {
        if (n < getMedium()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        adust();
    }

    private void remove(int n) {
        if (n < getMedium()) {
            maxHeap.remove(n);
        } else {
            minHeap.remove(n);
        }
        adust();
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


    //This method sucks
    public double[] medianSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int length = nums.length;
        boolean isEven = k % 2 == 0;
        int popSize;
        if (isEven) {
            popSize = k / 2 - 1;
        } else {
            popSize = k / 2;
        }
        int index = 0;
        int mid1;
        int mid2;
        int removeIndex = 0;
        List<Integer> pops = new ArrayList<Integer>(k);
        List<Double> mids = new ArrayList<Double>();
        boolean isRemoved;
        while (index < length) {
            minHeap.add(nums[index]);
            if (minHeap.size() == k) {
                pops.clear();
                isRemoved = false;
                for (int i = 0; i < popSize; i++) {
                    pops.add(minHeap.poll());
                }
                if (isEven) {
                    mid1 = minHeap.poll();
                    pops.add(mid1);
                    mid2 = minHeap.peek();
                    mids.add(((double) mid1 + (double) mid2) / 2);
                } else {
                    mids.add((double) minHeap.peek());
                }

                if (minHeap.remove(nums[removeIndex])) {
                    for (int i : pops) {
                        minHeap.offer(i);
                    }
                } else {
                    for (int i : pops) {
                        if (i == nums[removeIndex] && isRemoved == false) {
                            isRemoved = true;
                        } else {
                            minHeap.offer(i);
                        }
                    }
                }

                removeIndex++;
            }
            index++;
        }
        double[] result = new double[mids.size()];
        for (int i = 0, l = mids.size(); i < l; i++) {
            result[i] = mids.get(i);
        }
        return result;
    }
}
