package com.test.leetcode.hard;

import java.util.HashMap;

/**
 * Created by ben on 2017/6/2.
 */
public class LFUCache1 {
    HashMap<Integer, node> map1;
    HashMap<Integer, node[]> map2;
    int size, lowestFreq;

    public class node {
        int key;
        int value;
        int frequency;
        node prev;
        node next;

        public node(int k, int v, int f) {
            key = k;
            value = v;
            frequency = f;
        }
    }

    public void delete(node x) {
        node prev = x.prev;
        node next = x.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addToHead(int freq, node x) {
        if (!map2.containsKey(freq)) {
            node h = new node(0, 0, freq);
            node t = new node(0, 0, freq);
            h.next = t;
            t.prev = h;
            map2.put(freq, new node[]{h, t});
        }
        node head = map2.get(freq)[0];
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        x.prev = head;
    }

    public LFUCache1(int capacity) {
        map1 = new HashMap<Integer, node>();
        map2 = new HashMap<Integer, node[]>();
        size = capacity;
        lowestFreq = 0;
    }

    public int get(int key) {
        if (!map1.containsKey(key))
            return -1;
        node current = map1.get(key);
        delete(current);
        if (lowestFreq == current.frequency && map2.get(lowestFreq)[0].next.value == 0)
            lowestFreq += 1;
        current.frequency += 1;
        addToHead(current.frequency, current);
        return current.value;
    }

    public void put(int key, int value) {
        if (size == 0)
            return;
        if (map1.containsKey(key)) {
            node current = map1.get(key);
            delete(current);
            if (lowestFreq == current.frequency && map2.get(lowestFreq)[0].next.value == 0)
                lowestFreq += 1;
            current.value = value;
            current.frequency += 1;
            addToHead(current.frequency, current);
        } else {
            if (map1.size() == size) {
                node tail = map2.get(lowestFreq)[1];
                map1.remove(tail.prev.key);
                delete(tail.prev);
            }
            node nd = new node(key, value, 1);
            map1.put(key, nd);
            addToHead(1, nd);
            lowestFreq = 1;
        }
    }
}
