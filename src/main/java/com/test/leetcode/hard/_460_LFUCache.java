package com.test.leetcode.hard;

import java.util.*;

/**
 * Created by ben on 2017/6/2.
 */
public class _460_LFUCache {
    public class CacheItem {
        int key;
        int val;
        int count;
        double sequence;

        public CacheItem(int key, int value, double sequence) {
            this.key = key;
            this.val = value;
            this.count = 1;
            this.sequence = sequence;
        }

        public void increase(double sequence) {
            this.count++;
            this.sequence = sequence;
        }
    }

    private Map<Integer, CacheItem> map;
    private int capacity;
    private double sequence;

    public _460_LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        CacheItem ci = map.get(key);
        if (null == ci) {
            return -1;
        }
        ci.increase(this.getSequence());
        map.put(key, ci);
        return ci.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        CacheItem ci = map.get(key);
        if (null == ci) {
            if (map.size() >= this.capacity) {
                removeLeastFrequently();
            }
            map.put(key, new CacheItem(key, value, getSequence()));
        } else {
            ci.val = value;
            ci.increase(getSequence());
            map.put(key, ci);
        }
    }

    private void removeLeastFrequently() {
        int min = Integer.MAX_VALUE;
        CacheItem minCI = null;
        for (Map.Entry<Integer, CacheItem> entry : map.entrySet()) {
            if (entry.getValue().count < min) {
                min = entry.getValue().count;
                minCI = entry.getValue();
            } else if (entry.getValue().count == min) {
                if (minCI.sequence > entry.getValue().sequence) {
                    minCI = entry.getValue();
                }
            }
        }
        map.remove(minCI.key);
    }

    private double getSequence() {
        return this.sequence++;
    }
}
