package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/5/18.
 */
public class QueueReconstructionByHeight {
    public class Node {
        int height;
        int k;

        public Node(int h, int k) {
            this.height = h;
            this.k = k;
        }
    }

    private PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if (o1.height != o2.height) {
                return o2.height - o1.height;
            } else {
                return o1.k - o2.k;
            }
        }
    });

    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;

        for (int i = 0; i < length; i++) {
            this.pq.offer(new Node(people[i][0], people[i][1]));
        }
        List<Node> refList = new ArrayList<Node>(length);
        Node temp;
        while (!this.pq.isEmpty()) {
            temp = this.pq.poll();
            refList.add(temp.k, temp);
        }
        int[][] res = new int[length][2];
        for (int i = 0; i < length; i++) {
            temp = refList.get(i);
            res[i][0] = temp.height;
            res[i][1] = temp.k;
        }
        return res;
    }
}
