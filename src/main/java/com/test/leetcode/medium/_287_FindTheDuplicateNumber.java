package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/30.
 */
public class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    cnt++;
            }

            if (cnt > mid)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return min;
    }

    //假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。
    // 比如数组是213,则映射关系为0->2, 1->1, 2->3。假设这个一对一映射关系是一个函数f(n)，
    // 其中n是下标，f(n)是映射到的数。如果我们从下标为0出发，根据这个函数计算出一个值，
    // 以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。
    // 实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，0->2->3。

    //但如果有重复的话，这中间就会产生多对一的映射，比如数组2131,则映射关系为0->2, {1，3}->1, 2->3。
    // 这样，我们推演的序列就一定会有环路了，这里下标的序列是0->2->3->1->1->1->1->...，而环的起点就是重复的数。

    //所以该题实际上就是找环路起点的题，和Linked List Cycle II一样。
    // 我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，
    // 直到两个下标再次相同。这时候保持慢下标位置不变，再用一个新的下标从0开始，
    // 这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。
    // 对这个找环起点算法不懂的，请参考Floyd's Algorithm。
    public int findDuplicate1(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
