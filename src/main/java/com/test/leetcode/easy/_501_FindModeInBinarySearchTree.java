package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by ben on 2017/8/24.
 */
public class _501_FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root.val, 1);
        TreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (null != temp.left) {
                map.put(temp.left.val, map.getOrDefault(temp.left.val, 0) + 1);
                queue.add(temp.left);
            }
            if (null != temp.right) {
                map.put(temp.right.val, map.getOrDefault(temp.right.val, 0) + 1);
                queue.add(temp.right);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int i = 1;
        for (; i < list.size(); i++) {
            if (list.get(i).getValue() != list.get(i - 1).getValue()) break;
        }
        int[] r = new int[i];
        for (int j = 0; j < i; j++) {
            r[j] = list.get(j).getKey();
        }

        return r;
    }


    int maxCount = 0;
    int curVal;
    int curValCount = 0;
    int num_modes = 0;
    int[] result;

    private void perform(int val) {
        if (val != curVal) {
            curVal = val;
            curValCount = 0;
        }
        curValCount++;
        if (curValCount > maxCount) {
            maxCount = curValCount;
            num_modes = 1;
        } else if (curValCount == maxCount) {
            if (result != null) {
                result[num_modes] = curVal;
            }
            num_modes++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        perform(root.val);
        inorder(root.right);
    }

    public int[] findMode1(TreeNode root) {
        inorder(root);
        result = new int[num_modes];
        num_modes = 0;
        curValCount = 0;
        inorder(root);
        return result;
    }
}
