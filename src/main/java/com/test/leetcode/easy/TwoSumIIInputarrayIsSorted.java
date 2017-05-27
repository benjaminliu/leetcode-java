package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class TwoSumIIInputarrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return numbers;
        }

        int index1 = 0;
        int index2 = 1;

        while (index1 < numbers.length) {
            if (index2 >= numbers.length) {
                index1++;
                index2 = index1 + 1;
                continue;
            }
            if (numbers[index1] + numbers[index2] == target) {
                break;
            }
            if (numbers[index1] + numbers[index2] < target) {
                index2++;
                continue;
            }
            if (numbers[index1] + numbers[index2] > target) {
                index1++;
                index2 = index1 + 1;
                continue;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] answer = new int[2];

        if (numbers.length == 0) {
            return answer;
        }

        int start = 0;
        int end = numbers.length - 1;

        while (start != end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                return answer;
            } else {
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }
}
