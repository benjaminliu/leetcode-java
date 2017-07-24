package com.test.leetcode.medium;

import java.util.Stack;

/**
 * Created by ben on 2017/7/24.
 */
public class _331_VerifyPreorderSerializationOfABinary_Tree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        String[] ps = preorder.split(",");
        int len = ps.length;
        if (len == 0) {
            return false;
        }
        final String sharp = "#";
        if (len == 1) {
            if (sharp.equals(ps[0])) {
                return true;
            } else {
                return false;
            }
        }
        if (sharp.equals(ps[0])) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            //two # pop parent, and push a #
            if (sharp.equals(ps[i])) {
                //if last one is #
                while (!stack.isEmpty()) {
                    if (stack.peek() != sharp) {
                        break;
                    }
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }

                stack.push(sharp);
            } else {
                stack.push(ps[i]);
            }
        }

        if (stack.size() == 1 && stack.peek() == sharp) {
            return true;
        }
        return false;
    }

    //In a binary tree, if we consider null as leaves, then
    //1.all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
    //2.all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

    //Suppose we try to build this tree. During building,
    // we record the difference between out degree and in degree diff = outdegree - indegree.
    // When the next node comes, we then decrease diff by 1, because the node provides an in degree.
    // If the node is not null, we increase diff by 2, because it provides two out degrees.
    // If a serialization is correct, diff should never be negative and diff will be zero when finished.
    public boolean isValidSerialization1(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
