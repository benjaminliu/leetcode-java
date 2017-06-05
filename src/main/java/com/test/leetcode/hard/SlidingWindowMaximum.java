package com.test.leetcode.hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * Created by ben on 2017/6/5.
 */
public class SlidingWindowMaximum {
    private PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {


        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || k < 1 || k > nums.length) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (i < k) {
                pq.add(nums[i]);
                continue;
            }
            res[index] = pq.peek();
            pq.remove(nums[index]);
            pq.add(nums[i]);
            index++;
        }
        res[index] = pq.peek();
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0, right = 0, max = Integer.MIN_VALUE, index = 0;
        while (left <= right && right < nums.length) {
            while (right < nums.length && right - left < k) {
                if (nums[right] >= max) {
                    max = nums[right];
                    index = right;
                }
                right++;
            }
            if (right - left < k) {
                break;
            }
            res[left] = max;
            if (left == index) {
                max = Integer.MIN_VALUE;
                right = left + 1;
            }
            left++;
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }
}
