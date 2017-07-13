package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/7/12.
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int zeroCount = 0;
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        for (int i : nums) {
            if (i < 0) {
                negative.add(i);
            } else if (i > 0) {
                positive.add(i);
            } else {
                zeroCount++;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        if (zeroCount > 2) {
            result.add(Arrays.asList(0, 0, 0));
        }
        if (negative.size() == 0) {
            return result;
        }
        if (positive.size() == 0) {
            return result;
        }

        Collections.sort(negative, (o1, o2) -> {
            return o2 - o1;
        });
        Collections.sort(positive);

        Set<String> threeDuplicate = new HashSet<>();
        Set<String> twoDuplicate = new HashSet<>();

        if (zeroCount > 0) {
            //1 zero, 1 nagetive, 1 positive
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : negative) {
                map.put(-1 * i, 1);
            }
            for (int i : positive) {
                Integer temp = map.get(i);
                if (temp != null) {
                    threeDulipcate(result, threeDuplicate, -1 * i, 0, i);
                }
            }
        }

        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < positive.size() - 1; i++) {
            for (int j = i + 1; j < positive.size(); j++) {
                twoDuplicate(map, twoDuplicate, positive.get(i), positive.get(j));
            }
        }
        List<Integer[]> temp = null;
        for (int i : negative) {
            temp = map.get(i * -1);
            if (null != temp) {
                for (Integer[] t : temp) {
                    threeDulipcate(result, threeDuplicate, i, t[0], t[1]);
                }
            }
        }

        map.clear();
        for (int i = 0; i < negative.size() - 1; i++) {
            for (int j = i + 1; j < negative.size(); j++) {
                twoDuplicate(map, twoDuplicate, negative.get(i), negative.get(j));
            }
        }
        for (int i : positive) {
            temp = map.get(i * -1);
            if (null != temp) {
                for (Integer[] t : temp) {
                    threeDulipcate(result, threeDuplicate, t[1], t[0], i);
                }
            }
        }
        return result;
    }

    private void twoDuplicate(Map<Integer, List<Integer[]>> map, Set<String> check, int i1, int i2) {
        String key = i1 + "-" + i2;
        if (check.add(key)) {
            int key1 = (i1 + i2);
            List<Integer[]> temp = map.getOrDefault(key1, new ArrayList<>());
            temp.add(new Integer[]{i1, i2});
            map.put(key1, temp);
        }
    }

    private void threeDulipcate(List<List<Integer>> result, Set<String> check, int i1, int i2, int i3) {
        String key = i1 + "-" + i2 + "-" + i3;
        if (check.add(key)) {
            result.add(Arrays.asList(i1, i2, i3));
        }
    }


    // a + b + c = 0
    // -a = b + c
    public List<List<Integer>> threeSum1(int[] nums) {
        int target, start, end;
        int len = nums.length;
        List<Integer> triplet;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            //ignore duplication
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //if a > 0,  then  b > 0, c> 0,   why wasting time
            if (nums[i] > 0) {
                break;
            }
            target = -1 * nums[i];
            start = i + 1;
            end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (target == sum) {
                    triplet = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    results.add(triplet);
                    //ignore duplication
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (target > sum) {
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
        return results;
    }
}
