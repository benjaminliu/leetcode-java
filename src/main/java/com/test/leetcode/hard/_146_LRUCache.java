package com.test.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/6/2.
 */
public class _146_LRUCache {
    public class DoubleList {
        int key;
        int val;
        DoubleList prev;
        DoubleList next;

        public DoubleList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int index = 0;
    int capacity;
    DoubleList tail;
    DoubleList head;
    Map<Integer, DoubleList> map;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoubleList>();
        this.head = new DoubleList(0, 0);
        this.tail = new DoubleList(0, 0);
        head.next = tail;
        tail.prev = head;
        this.index = 0;
    }

    public void addFirst(DoubleList node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(DoubleList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleList node = map.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            DoubleList node = map.get(key);
            remove(node);
            addFirst(node);
            return;
        } else {
            DoubleList node = new DoubleList(key, value);
            map.put(key, node);
            if (index < capacity) {
                index++;
                addFirst(node);
            } else {
                map.remove(tail.prev.key);
                remove(tail.prev);
                addFirst(node);
            }
        }
    }
}
