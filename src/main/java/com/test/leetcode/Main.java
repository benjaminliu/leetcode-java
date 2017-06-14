package com.test.leetcode;

import com.test.leetcode.common.*;
import com.test.leetcode.easy.*;
import com.test.leetcode.medium.*;
import com.test.leetcode.hard.*;
import com.test.others.Combinations;
import com.test.others.Permucations;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;


/**
 * Created by ben on 2017/5/14.
 */
public class Main {
    public static void main(String args[]) {
        CombinationSumIV c = new CombinationSumIV();
        int i = c.combinationSum4(new int[]{1, 2, 3}, 4);
        out.print(i);

//        LicenseKeyFormatting l = new LicenseKeyFormatting();
//        String aaaa = l.licenseKeyFormatting("2-4A0r7-4k", 4);
//        out.print(aaaa);

//        Combinations c = new Combinations("wxyz");
//        c.combine();

//        Permucations p = new Permucations("abcd");
//        p.permute();

//        SlidingWindowMaximum s = new SlidingWindowMaximum();
//        int[] ints = s.maxSlidingWindow2(new int[]{8, 7, 6, 5, 4, 10, 3, 2, 1}, 3);
//        out.print(Arrays.toString(ints));

//        ReverseStringII r = new ReverseStringII();
//        String abcd = r.reverseStr("dcbagfe", 4);
//        out.print(abcd);

//        MajorityElement m = new MajorityElement();
//        int i = m.majorityElement(new int[]{1});
//        out.print(i);


//        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
//        int leetcode = f.firstUniqChar("leetcode");
//        out.print(leetcode);

//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(3);
//        root.left = left;
//        root.right = right;
//
//        BinaryTreeTilt b = new BinaryTreeTilt();
//        int tilt = b.findTilt(root);
//        out.print(tilt);

//        TwoSumIIInputarrayIsSorted t = new TwoSumIIInputarrayIsSorted();
//        int[] ints = t.twoSum(new int[]{5,25,75}, 100);
//        out.print(Arrays.toString(ints));

//        AddDigits a = new AddDigits();
//        int i = a.addDigits(10);
//        out.print(i);

//        TreeNode node = new TreeNode(0);
//        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
//        int i = m.maxDepth(node);
//        out.print(i);

//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        FindAllNumbersDisappearedInAnArray a = new FindAllNumbersDisappearedInAnArray();
//        List<Integer> disappearedNumbers = a.findDisappearedNumbers(nums);
//        out.print(disappearedNumbers);

//        int[] nums = {2, 2, 1};
//        SingleNumber s = new SingleNumber();
//        int i = s.singleNumber(nums);
//        out.print(i);

//        int[][] nums = {{1, 1, 1, 1}, {1, 0, 0, 1}, {1,0, 0, 1}, {1, 0, 1, 1}};
//        IslandPerimeter perimeter = new IslandPerimeter();
//        int i = perimeter.islandPerimeter2(nums);
//        out.print(i);

//        int[] nums1 = {4, 1, 2};
//        int[] nums2 = {1, 3, 4, 2};
//
//        NextGreaterElementI n = new NextGreaterElementI();
//        int[] ints = n.nextGreaterElement(nums1, nums2);
//        out.print(Arrays.toString(ints));


//        String e = "-1/2+1/2";
//        String e = "1/3-1/2";
//        FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new FractionAdditionAndSubtraction();
//        String s = fractionAdditionAndSubtraction.fractionAddition(e);
//        out.print(s);

//        int[] nums = {1, 2, 3, 4};
//        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
//        int[] ints = productOfArrayExceptSelf.productExceptSelf(nums);
//        out.print(Arrays.toString(ints));
//        String s ="tree";
//        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
//        String s1 = sortCharactersByFrequency.frequencySort(s);
//        out.print(s1);

//        TreeNode root = new TreeNode(5);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(-5);
//        root.left = root2;
//        root.right = root3;
//
//        MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();
//        int[] frequentTreeSum = mostFrequentSubtreeSum.findFrequentTreeSum(root);
//        out.print(Arrays.toString(frequentTreeSum));

//        TreeNode root = new TreeNode(1);
//        TreeNode rootl = new TreeNode(3);
//        TreeNode rootr = new TreeNode(2);
//        root.left = rootl;
//        root.right = rootr;
//
//        TreeNode root5 = new TreeNode(5);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root9 = new TreeNode(9);
//
//        rootl.left = root5;
//        rootl.right = root3;
//
//        rootr.right = root9;
//
//        FindLargestValueInEachTreeRow findLargestValueInEachTreeRow = new FindLargestValueInEachTreeRow();
//        List<Integer> integers = findLargestValueInEachTreeRow.largestValues(root);
//
//        out.print(integers);


//        int[] a = {1, 2, 3, 4,5,6};
//        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
//        int i = arithmeticSlices.numberOfArithmeticSlices(a);
//        out.print(i);

//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
//        int[][] ints = queueReconstructionByHeight.reconstructQueue(people);
//
//        for (int i = 0; i < ints.length; i++) {
//            out.println(Arrays.toString(ints[i]));
//        }


//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
//        double[] doubles = slidingWindowMedian.medianSlidingWindow(nums, 3);
//        out.print(Arrays.toString(doubles));

//        FindBottomLeftTreeValue.TreeNode node = new FindBottomLeftTreeValue.TreeNode(2);
//        node.left = new FindBottomLeftTreeValue.TreeNode(1);
//        node.right = new FindBottomLeftTreeValue.TreeNode(3);
//        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
//        int bottomLeftValue = findBottomLeftTreeValue.findBottomLeftValue(node);
//
//        out.print(bottomLeftValue);

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
