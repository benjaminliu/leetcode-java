package com.test;

import com.test.leetcode.common.*;
import com.test.leetcode.medium.*;
import com.test.leetcode.hard.*;
import com.test.leetcode.easy.*;

import com.test.others.*;


import java.util.Arrays;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.lang.System.out;


/**
 * Created by ben on 2017/5/14.
 */
public class Main {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();

        _556_NextGreaterElementIII n = new _556_NextGreaterElementIII();
        int i = n.nextGreaterElement(1234);
        out.print(i);


//        MatrixChainMultiply m = new MatrixChainMultiply();
//        int i = m.matrixChainOrder(new int[]{30, 35, 15, 5, 10, 20, 25});
//        out.print(i);


//        Knapsack k = new Knapsack();
//        int knapsack = k.knapsack(new int[][]{{2, 6}, {2, 3}, {6, 5}, {5, 4}, {4, 6}}, 9);
//        out.print(knapsack);

//        _32_LongestValidParentheses l = new _32_LongestValidParentheses();
////        int i = l.longestValidParentheses(")(()()");
//        int i = l.longestValidParentheses("(()");
//        out.print(i);


//        _331_VerifyPreorderSerializationOfABinary_Tree v = new _331_VerifyPreorderSerializationOfABinary_Tree();
//        boolean validSerialization = v.isValidSerialization("8,#,5,#,2,5,#,7,9,#,8,#,#,#,#");
//        out.print(validSerialization);


//        String[] ss = new String[]{
//                "....5..1.",
//                ".4.3.....",
//                ".....3..1",
//                "8......2.",
//                "..2.7....",
//                ".15......",
//                ".....2...",
//                ".2.9.....",
//                "..4......"};
//
//        char[][] cs = new char[9][];
//        for(int i= 0;i<9;i++){
//            cs[i] = ss[i].toCharArray();
//        }
//
//        _36_ValidSudoku v = new _36_ValidSudoku();
//        boolean validSudoku = v.isValidSudoku(cs);
//
//        out.print(validSudoku);


//        _31_NextPermutation n = new _31_NextPermutation();
//        int[] nums = new int[]{2, 3, 1};
//        n.nextPermutation(nums);
//        out.print(Arrays.toString(nums));

//        _30_SubstringWithConcatenationOfAllWords s = new _30_SubstringWithConcatenationOfAllWords();
//        List<Integer> barfoothefoobarman = s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
//        out.print(barfoothefoobarman);


//        int[][] matrix = new int[5][];
//        matrix[0] = new int[]{1,2,2,3,5};
//        matrix[1] = new int[]{3,2,3,4,4};
//        matrix[2] = new int[]{2,4,5,3,1};
//        matrix[3] = new int[]{6,7,1,4,5};
//        matrix[4] = new int[]{5,1,1,2,4};
//
//        _417_PacificAtlanticWaterFlow p = new _417_PacificAtlanticWaterFlow();
//        p.pacificAtlantic1(matrix);


//        _51_NQueens n = new _51_NQueens();
//        List<List<String>> lists = n.solveNQueens(4);
//        for (List<String> l : lists) {
//            out.println(l);
//        }

//        _28_ImplementStrStr i = new _28_ImplementStrStr();
//        int i1 = i.strStr("mississippi", "pi");
//        out.print(i1);


//        _25_ReverseNodesInKGroup r = new _25_ReverseNodesInKGroup();
//        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(4);
//        ListNode listNode = r.reverseKGroup(root, 2);
//        printListNode(listNode);

//        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(4);
//        _24_SwapNodesInPairs s = new _24_SwapNodesInPairs();
//        ListNode listNode = s.swapPairs(root);
//        printListNode(listNode);

//        _22_GenerateParentheses g = new _22_GenerateParentheses();
//        List<String> strings = g.generateParenthesis(1);
//        out.print(strings);

//        _354_RussianDollEnvelopes r = new _354_RussianDollEnvelopes();
//        int[][] nums = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
//        int i = r.maxEnvelopes(nums);
//        out.print(i);

//        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
//        _19_RemoveNthNodeFromEndOfList r = new _19_RemoveNthNodeFromEndOfList();
//        ListNode listNode = r.removeNthFromEnd(l, 2);
//        printListNode(listNode);


//        _567_PermutationInString p = new _567_PermutationInString();
//        boolean b = p.checkInclusion1("hello", "ooolleooolelh");
//        out.print(b);


//        _18_4Sum s = new _18_4Sum();
//        List<List<Integer>> lists = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
//        for (List<Integer> list : lists) {
//            out.println(list);
//        }

//        _16_3SumClosest s = new _16_3SumClosest();
//        int i = s.threeSumClosest(new int[]{1, 1, 1,0}, 100);
//        out.print(i);

//        SumOfSequenceEqualsTarget s = new SumOfSequenceEqualsTarget();
//        List<List<Integer>> sequences = s.findSequences(100000);
//        for (List<Integer> list : sequences) {
//            out.println(list);
//        }


//        _15_3Sum s = new _15_3Sum();
////        List<List<Integer>> lists = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//    List<List<Integer>> lists = s.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
//
//        for (List<Integer> list : lists) {
//            out.println(list);
//        }

//        _14LongestCommonPrefix l = new _14LongestCommonPrefix();
//        String s = l.longestCommonPrefix(new String[]{"c", "c","c"});
//        out.print(s);

//        _11ContainerWithMostWater c = new _11ContainerWithMostWater();
//        int i = c.maxArea(new int[]{1, 1});
//        out.print(i);

//        _532KDiffPairsInAnArray k = new _532KDiffPairsInAnArray();
//        int pairs = k.findPairs1(new int[]{3, 1, 4, 1, 5}, 2);
//        out.print(pairs);

//        MinimumCoinChange m = new MinimumCoinChange();
//        int change = m.change1(10, new int[]{1, 2, 3});
//        out.print(change);

//        _10RegularExpressionMatching r = new _10RegularExpressionMatching();
//        boolean match = r.isMatch("aab", "c*a*b");
//        out.print(match);

//        _60PermutationSequence p = new _60PermutationSequence();
//        String permutation = p.getPermutation(3, 2);
//        out.print(permutation);

//        _33SearchInRotatedSortedArray s = new _33SearchInRotatedSortedArray();
//        int search = s.search(new int[]{1}, 1);
//        out.print(search);

//        _17LetterCombinationsOfAPhoneNumber l = new _17LetterCombinationsOfAPhoneNumber();
//        List<String> strings = l.letterCombinations("2");
//        out.print(strings);

//        _6ZigZagConversion z = new _6ZigZagConversion();
//        String ab = z.convert("ABcd", 3);
//        out.print(ab);

//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//
//        _2AddTwoNumbers a = new _2AddTwoNumbers();
//        ListNode listNode = a.addTwoNumbers(l1, l2);
//
//        printListNode(listNode);


//        TreeNode root = new TreeNode(1);
//        root.left = null;
//        TreeNode right = new TreeNode(2);
//        right.left = new TreeNode(3);
//        right.right = null;
////        right.right = new TreeNode(4);
////        root.left = new TreeNode(5);
//        root.right = right;
//        _94BinaryTreeInorderTraversal b = new _94BinaryTreeInorderTraversal();
//        List<Integer> integers = b.inorderTraversal(root);
//
//        out.print(integers);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        ReverseLinkedListII r = new ReverseLinkedListII();
//        ListNode listNode = r.reverseBetween2(head, 2, 3);
//
//        while (listNode != null) {
//            out.println(listNode.val);
//            listNode = listNode.next;
//        }

//        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
//        int i = b.maxProfit(new int[]{7, 6, 4, 3, 1});
//        out.print(i);

//        SqrtX s = new SqrtX();
//        int i = s.mySqrt1(1);
//        out.print(i);

//        _29DivideTwoIntegers d = new _29DivideTwoIntegers();
//        int divide = d.divide(100, 5);
//        out.println(divide);

//        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
//        double medianSortedArrays3 = m.findMedianSortedArrays3(new int[]{ 5}, new int[]{1,2, 3, 4, 6, 7, 8, 9});
//        out.print("result: " + medianSortedArrays3);

//        AddStrings a = new AddStrings();
//
//        String s = a.addStrings("1", "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//        out.print(s);
//        CombinationSumIV c = new CombinationSumIV();
//        int i = c.combinationSum4(new int[]{1, 2, 3}, 4);
//        out.print(i);

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
//        _508MostFrequentSubtreeSum mostFrequentSubtreeSum = new _508MostFrequentSubtreeSum();
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

        long endTime = System.currentTimeMillis();
        System.out.println("\n\r当前程序耗时：" + (endTime - startTime) + "ms");
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            out.println(listNode.val);
            listNode = listNode.next;
        }
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
//        _566_ReshapeTheMatrix matrixReshape = new _566_ReshapeTheMatrix();
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
