package com.test.leetcode;

import com.test.leetcode.problems.*;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by ben on 2017/5/14.
 */
public class Main {
    public static void main(String args[]) {

        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
        DistributeCandies distributeCandies = new DistributeCandies();
        int i = distributeCandies.distributeCandies(nums);
        out.print(i);

//        int[][] nums = new int[][]{{1, 2}, {3, 4}};
//        MatrixReshape matrixReshape = new MatrixReshape();
//        int[][] ints = matrixReshape.matrixReshape(nums, 1, 4);
//        out.print(Arrays.toString(ints));

//        int[] nums = new int[]{1, 2, 3, 2};
//        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
//        int i = arrayPartitionI.arrayPairSum1(nums);
//        out.println(i);

//        HammingDistance hammingDistance = new HammingDistance();
//        int i = hammingDistance.hammingDistance1(1, 4);
//        System.out.println(i);

//        int[] nums = new int[]{ 3 ,2, 4 };
//        int target = 6;
//        TwoSum twoSum = new TwoSum();
//        int[] results = twoSum.twoSum1(nums, target);
//        if(null == results){
//            System.out.println("null");
//        }
//        else {
//            for(int i = 0; i < results.length; i++){
//                System.out.print(results[i]);
//                System.out.print(", ");
//            }
//        }
    }
}
