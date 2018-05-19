package com.test.datastructure;

import java.util.Arrays;

/**
 * Created by ben on 2018/5/19.
 */
public class MinHeap {
    private int[] arr;
    private int size;

    public MinHeap() {
    }

    public void buildMinHeap(int[] nums) {
        if (null == nums || nums.length == 0)
            throw new IllegalArgumentException("empty nums");
        size = nums.length;
        arr = Arrays.copyOf(nums, size);

        for (int i = size / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public int extractMin() {
        int min = arr[0];
        arr[0] = arr[--size];
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int n) {
        if (n < size) {
            int left = left(n);
            if (left >= size) return;

            int minIdx = n;
            if (arr[minIdx] > arr[left]) {
                minIdx = left;
            }

            int right = left + 1;
            if (right < size) {
                if (arr[minIdx] > arr[right]) {
                    minIdx = right;
                }
            }

            if (minIdx != n) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[n];
                arr[n] = temp;
                bubbleDown(minIdx);
            }
        }
    }

    private void bubbleUp(int n) {
        if (parent(n) == -1) {
            return;
        }
        int p = parent(n);
        if (arr[n] < arr[p]) {
            int temp = arr[p];
            arr[p] = arr[n];
            arr[n] = temp;

            bubbleUp(p);
        }
    }

    private int parent(int n) {
        if (n == 0) {
            return -1;
        }
        return n / 2;
    }

    private int left(int n) {
        return 2 * n;
    }
}
