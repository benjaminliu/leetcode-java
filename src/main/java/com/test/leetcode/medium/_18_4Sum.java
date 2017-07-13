package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/7/13.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> temp;
        List<List<Integer>> result = new ArrayList<>();

        int start, end, sum, tempTarget;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                start = j + 1;
                end = len - 1;
                tempTarget = target - nums[i] - nums[j];
                while (start < end) {
                    sum = nums[start] + nums[end];
                    if (sum == tempTarget) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (sum < tempTarget) {
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                    } else {
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
