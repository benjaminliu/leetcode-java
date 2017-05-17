package com.test.leetcode;

import com.test.leetcode.medium.*;

import java.util.Arrays;

import static java.lang.System.out;


/**
 * Created by ben on 2017/5/14.
 */
public class Main {
    public static void main(String args[]) {
        FindBottomLeftTreeValue.TreeNode node = new FindBottomLeftTreeValue.TreeNode(2);
        node.left = new FindBottomLeftTreeValue.TreeNode(1);
        node.right = new FindBottomLeftTreeValue.TreeNode(3);
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        int bottomLeftValue = findBottomLeftTreeValue.findBottomLeftValue(node);

        out.print(bottomLeftValue);

//        CountingBits countingBits = new CountingBits();
//        int[] ints = countingBits.countBits(8);
//
//        out.print(Arrays.toString(ints));


//        EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new EncodeAndDecodeTinyURL();
//        String url = "https://leetcode.com/problems/design-tinyurl";
//        String encode = encodeAndDecodeTinyURL.encode(url);
//        String decode = encodeAndDecodeTinyURL.decode(encode);
//        System.out.println(decode);
    }

    private static void easy() {
        //        String[] ss = {"Hello", "Alaska", "Dad", "Peace"};
//        KeyboardRow keyboardRow = new KeyboardRow();
//        String[] words = keyboardRow.findWords(ss);
//        out.print(Arrays.toString(words));


//        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
//        String s = "Let's take LeetCode contest";
//        String s1 = reverseWordsInAStringIII.reverseWords(s);
//        out.print(s1);

//        NumberComplement numberComplement = new NumberComplement();
//        int complement = numberComplement.findComplement(1);
//        out.print(complement);

//        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3};
//        DistributeCandies distributeCandies = new DistributeCandies();
//        int i = distributeCandies.distributeCandies(nums);
//        out.print(i);

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
