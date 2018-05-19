package com.test.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2018/5/19.
 */
public class MergeSort {
    private Queue<Integer> leftQueue = new LinkedList<>();
    private Queue<Integer> rightQueue = new LinkedList<>();

    public void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;

        split(nums, 0, nums.length - 1);
    }

    private void split(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            split(nums, left, mid);
            split(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= mid; i++)
            leftQueue.add(nums[i]);

        for (int i = mid + 1; i <= right; i++)
            rightQueue.add(nums[i]);

        int i = left;

        //when 2 queue all have value, we compare the first number of 2 queue.
        //we take the smaller one, and put it into nums
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            if (leftQueue.peek() <= rightQueue.peek()) {
                nums[i++] = leftQueue.poll();
            } else {
                nums[i++] = rightQueue.poll();
            }
        }

        //one queue is empty, the other queue are bigger numbers
        while (!leftQueue.isEmpty())
            nums[i++] = leftQueue.poll();

        while (!rightQueue.isEmpty())
            nums[i++] = rightQueue.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 9, 1, 7, 6, 8, 0, 5};

        MergeSort sorter = new MergeSort();
        sorter.sort(nums);

        System.out.print(Arrays.toString(nums));
    }
}
