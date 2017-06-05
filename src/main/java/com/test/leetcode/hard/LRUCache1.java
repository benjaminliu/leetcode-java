package com.test.leetcode.hard;

import java.util.Hashtable;

/**
 * Created by ben on 2017/6/2.
 */
public class LRUCache1 {
    class DLinkNode {
        int key;
        int value;

        DLinkNode prev;
        DLinkNode next;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int count;
    private DLinkNode head, tail;
    private Hashtable<Integer, DLinkNode> bucket = new Hashtable<Integer, DLinkNode>();

    private void moveToTail(DLinkNode node) {
        //Take care of Prev realation First
        node.prev = this.tail.prev;
        this.tail.prev = node;

        //Then take care of Next relation
        node.prev.next = node;
        node.next = tail;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new DLinkNode(-1, -1);
        tail = new DLinkNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = bucket.get(key);
        if (node == null)
            return -1;
        //Remove the Node First
        this.removeNode(node);
        //Most Used Element should be Moved to the Tail
        this.moveToTail(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = new DLinkNode(key, value);
        //If theres alrady a value with this key
        //The Reason using get(key) is the Node will be moved to the tail if the key is found
        if (this.get(key) != -1) {
            node = bucket.get(key);
            node.value = value;
            return;
        }

        //If the Bucket is reaching the capacity, we need to remove the Head(Least used element)
        this.count++;
        if (this.count > this.capacity) {
            bucket.remove(head.next.key);
            //remove the First element
            this.removeNode(head.next);
            this.count--;
        }

        bucket.put(key, node);
        //Put the node to thr tail, cuz it's Most Frequently used element
        moveToTail(node);

        return;
    }
}
