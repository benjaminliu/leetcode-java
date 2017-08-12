package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/5/23.
 */
public class _347_TopKFrequentElements {
    public class Node {
        int value;
        int count;

        Node(int v, int c) {
            this.value = v;
            this.count = c;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int n : nums) {
            temp = map.getOrDefault(n, 0);
            map.put(n, temp + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new Node(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> res = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            res.add(0, queue.poll().value);
        }
        return res;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int n : nums) {
            temp = map.getOrDefault(n, 0);
            map.put(n, temp + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    if (res.size() < k) {
                        res.add(n);
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }

}
