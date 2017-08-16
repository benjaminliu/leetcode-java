package com.test;

import com.test.leetcode.common.*;
import com.test.leetcode.medium.*;
import com.test.leetcode.hard.*;
import com.test.leetcode.easy.*;

import com.test.others.*;


import java.util.ArrayList;
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

        _342_PowerOfFour p= new _342_PowerOfFour();
        boolean powerOfFour = p.isPowerOfFour(5);
        out.print(powerOfFour);

//        _326_PowerOfThree p = new _326_PowerOfThree();
//        boolean powerOfThree = p.isPowerOfThree(45);
//        out.print(powerOfThree);

//        _138_CopyListWithRandomPointer.RandomListNode r = new _138_CopyListWithRandomPointer.RandomListNode(1);
//        r.next = new _138_CopyListWithRandomPointer.RandomListNode(2);
//        r.next.next = new _138_CopyListWithRandomPointer.RandomListNode(2);
//        r.next.next.next = new _138_CopyListWithRandomPointer.RandomListNode(2);
//
//        r.random = r.next.next;
//        r.next.random = r;
//        r.next.next.random = r.random;
//        r.next.next.next.random = r.next;
//
//        _138_CopyListWithRandomPointer c = new _138_CopyListWithRandomPointer();
//        _138_CopyListWithRandomPointer.RandomListNode randomListNode = c.copyRandomList(r);
//
//        while (randomListNode != null) {
//            out.println(randomListNode.label + "->" + randomListNode.random.label);
//            randomListNode = randomListNode.next;
//        }

//        _290_WordPattern w = new _290_WordPattern();
//        boolean abba = w.wordPattern("abba", "dog cat cat dog");
//        out.print(abba);

//        _278_FirstBadVersion f = new _278_FirstBadVersion();
//        int i = f.firstBadVersion(2126753390);
//        out.print(i);

//        ListNode n = new ListNode(1);
//        n.next = new ListNode(1);
//        n.next.next = new ListNode(2);
//        n.next.next.next = new ListNode(1);
//        _234_PalindromeLinkedList p = new _234_PalindromeLinkedList();
//        boolean palindrome = p.isPalindrome(n);
//        out.print(palindrome);

//        _659_SplitArrayIntoConsecutiveSubsequences s = new _659_SplitArrayIntoConsecutiveSubsequences();
//        boolean possible = s.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5});
//        out.print(possible);

//        _219_ContainsDuplicate_II c = new _219_ContainsDuplicate_II();
//        c.containsNearbyDuplicate(new int[]{1,2,  1},0);

//        _204_CountPrimes c = new _204_CountPrimes();
//        int i = c.countPrimes2(499979);
//        out.print(i);

//        ListNode n = new ListNode(1);
//        n.next = new ListNode(1);
////        n.next.next = new ListNode(3);
////        n.next.next.next = new ListNode(4);
////        n.next.next.next.next = new ListNode(5);
////        n.next.next.next.next.next = new ListNode(6);
//        _203_RemoveLinkedListElements r = new _203_RemoveLinkedListElements();
//        ListNode listNode = r.removeElements(n, 1);
//
//        printListNode(listNode);


//        _191_NumberOf1Bits n = new _191_NumberOf1Bits();
//        int i = n.hammingWeight(  -0  );
//        out.print(i);

//        _190_ReverseBits r = new _190_ReverseBits();
//        int i = r.reverseBits1(43261596);
//        out.print(i);

//        _189_RotateArray r = new _189_RotateArray();
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
//        r.rotate(nums, 17);
//        out.print(Arrays.toString(nums));

//        _168_ExcelSheetColumnTitle e  = new _168_ExcelSheetColumnTitle();
//        String s = e.convertToTitle(27);
//        out.print(s);

//        _155_MinStack m = new _155_MinStack();
//        m.push(-2);
//        m.push(0);
//        m.push(-3);
//
//        int i = m.getMin();
//        out.println(i);
//        m.pop();
//        i = m.top();
//        out.println(i);
//        i = m.getMin();
//        out.println(i);

//        _125_ValidPalindrome v = new _125_ValidPalindrome();
//        boolean ab = v.isPalindrome(" apG0i4maAs::sA0m4i0Gp0");
//        out.print(ab);

//        _371_SumOfTwoIntegers s = new _371_SumOfTwoIntegers();
//        int sum1 = s.getSum1(3, 1);
//        out.println(sum1);

//        TreeNode root = new TreeNode(1);
////        root.left = new TreeNode(2);
////        root.left.left = new TreeNode(3);
////        root.left.left.left= new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
////        root.right.right.right = new TreeNode(4);
//        _110_BalancedBinaryTree b = new _110_BalancedBinaryTree();
//        boolean balanced = b.isBalanced(root);
//        out.print(balanced);


//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        _107_BinaryTreeLevelOrderTraversal_II b = new _107_BinaryTreeLevelOrderTraversal_II();
//        List<List<Integer>> lists = b.levelOrderBottom(root);
//        for(List<Integer> ls : lists){
//            out.println(ls);
//        }

//        _67_AddBinary a = new _67_AddBinary();
//        String s = a.addBinary("1010", "1011");
//        out.print(s);

//        _53_MaximumSubarray m = new _53_MaximumSubarray();
//        int i = m.maxSubArray(new int[]{1});
//        out.print(i);

//        _637_AverageOfLevelsInBinaryTree a = new _637_AverageOfLevelsInBinaryTree();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        List<Double> doubles = a.averageOfLevels(root);
//        out.print(doubles);

//        TreeNode t1 = new TreeNode(1);
//        TreeNode tl1 = new TreeNode(3);
//        TreeNode tll1 = new TreeNode(5);
//        TreeNode tr1 = new TreeNode(2);
//
//        t1.left = tl1;
//        t1.right = tr1;
//        tl1.left = tll1;
//
//        TreeNode t2 = new TreeNode(2);
//        TreeNode tl2 = new TreeNode(1);
//        TreeNode tlr2 = new TreeNode(4);
//        TreeNode tr2 = new TreeNode(3);
//        TreeNode trr2 = new TreeNode(7);
//
//        t2.left = tl2;
//        t2.right = tr2;
//        tl2.right = tlr2;
//        tr2.right = trr2;

//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(1);
//
//
//        _617_MergeTwoBinaryTrees m = new _617_MergeTwoBinaryTrees();
//        TreeNode treeNode = m.mergeTrees(t1, t2);
//        out.print(treeNode);

//        _205_IsomorphicStrings i = new _205_IsomorphicStrings();
//        boolean isomorphic = i.isIsomorphic("egg", "add");
//        out.print(isomorphic);

//        _50_Pow p = new _50_Pow();
//        double v = p.myPow(2.00000,
//                -2147483648);
//        out.print(v);

//        _49_GroupAnagrams g = new _49_GroupAnagrams();
//      //  String[] ss = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] ss = new String[]{"yak","rum","yak","tip","pep","feb","paw"};
////        String[] ss = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
//        List<List<String>> lists = g.groupAnagrams(ss);
//        for (List<String> l : lists) {
//            out.println(l);
//        }

//        _640_SolveTheEquation s = new _640_SolveTheEquation();
//        String s1 = s.solveEquation("0x=0");
//        out.print(s1);

//        _522_LongestUncommonSubsequenceII l = new _522_LongestUncommonSubsequenceII();
//        int luSlength = l.findLUSlength(new String[]{"abcde", "abcde", ""});
//        out.print(luSlength);

//        _46_Permutations p = new _46_Permutations();
//        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});
//        for(List<Integer> per : permute){
//            out.println(per);
//        }

//        _43_MultiplyStrings m = new _43_MultiplyStrings();
//        String multiply = m.multiply("99", "99");
//        out.print(multiply);

//        _38_CountAndSay c = new _38_CountAndSay();
//        String s = c.countAndSay(5);
//        out.print(s);

//        _498_DiagonalTraverse d = new _498_DiagonalTraverse();
//        int[] diagonalOrder = d.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
//        out.print(Arrays.toString(diagonalOrder));


//
//        _66_PlusOne p = new _66_PlusOne();
//        int[] ints = p.plusOne(new int[]{9});
//        out.print(Arrays.toString(ints));

//        _115_DistinctSubsequences d = new _115_DistinctSubsequences();
//        int i = d.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
//                "bcddceeeebecbc");
//        out.print(i);

//        _502_IPO i = new _502_IPO();
//        int maximizedCapital = i.findMaximizedCapital1(4, 1,
//                new int[]{1,1,1,1},
//                new int[]{0,1,2,3});
////                new int[]{319,178,37,756,152,763,481,1055,594,825,759,494,1087,696,717,358,1091,1145,1043,245,779,957,3,1060,1141,926,226,657,869,740,1170,746,889,416,634,209,1189,1076,819,1144,40,807,561,400,283,133,186,839,1043,491,936,559,70,9,854,1172,9,739,871,436,1087,1029,66,561,798,1141,701,1020,1072,92,636,509,392,77,84,202,843,563,329,906,101,997,1162,105,876,460,285,446,753,516,60,932,323,659,9,639,1041,861,1199,343,792,1114,536,405,542,805,929,589,538,410,143,114,24,1064,682,536,1016,1141,843,472,817,196,673,189,915,196,755,203,956,283,833,836,22,899,232,655,572,207,819,639,1024,887,407,385,251,896,165,290,193,357,870,678,411,697,998,344,628,866,1004,894,547,574,36,847,691,601,896,363,21,1133,115,658,855,1042,2,189,230,215,747,971,581,809,832,311,35,639,1127,701,167,672,763,997,1061,1170,289,806,91,198,720,67,273,863,437,152,671,635,968,107,58,453,392,236,875,719,44,850,176,580,937,227,125,851,1188,915,747,1175,69,743,250,275,290,787,780,516,775,279,256,649,83,1180,372,655,813,750,381,807,988,977,430,282,1067,551,726,756,372,17,1016,550,1128,223,174,85,1039,1,27,178,822,243,440,79,772,211,640,454,1141,654,351,54,794,711,157,492,307,1156,937,212,461,417,741,1104,642,1147,833,1194,1066,1070,876,1045,341,854,1014,787,518,404,1068,385,756,998,298,439,917,183,71,363,38,828,372,1071,195,481,1153,871,712,803,849,145,1144,410,420,561,678,241,498,548,436,871,810,180,635,119,665,551,1132,807,408,685,489,274,459,28,987,935,310,284,1163,924,812,267,1123,782,1065,1075,1199,1047,289,280,1044,931,1056,625,672,150,41,1084,998,151,483,226,548,277,1187,1010,262,1048,493,1084,845,1127,1009,773,129,547,798,118,559,463,972,666,1155,519,381,405,819,201,790,729,1100,614,691,3,386,206,514,387,612,1073,158,67,1116,164,496,1056,1159,348,530,28,1177,774,1139,559,563,310,916,897,36,1060,173,952,123,635,911,711,304,611,481,645,532,1033,385,402,797,117,307,969,1147,1127,434,1099,1043,104,74,257,778,934,901,106,84,525,138,698,877,1009,487,450,649,736,802,1032,456,757,10,2,720,1155,234,844,880,1053,1134,821,1094,970,1095,976,101,1163,104,38,198,350,896,345,867,1129,1064,403,228,1103,416,561,722,915,1161,252,45,632,1163,232,174,964,876,1126,479,432,984,815,544,1005,620,497,1021,763,169,1028,706,1112,150,368,483,251,721,492,686,1105,38,1140,1085,153,366,428,296,28,648,873,21,236,393,581,1043,1086,747,402,201,1196,416,788,318,257,815,735,1023,1143,1100,922,1033,884,824,963,159,904,21,1168,511,723,400,239,338,89,1099,572,674,54,891,426,277,91,504,302,616,468,506,917,491,744,1091,1051,594,465,850,338,417,320,1160,364,480,855,86,305,225,833,637,760,1147,613,236,460,664,1183,38,806,100,654,852,975,816,506,1092,275,6,229,972,53,554,370,63,651,701,304,1011,672,353,118,1111,448,549,151,1087,909,420,1095,663,1119,1124,729,578,733,861,1154,1195,387,1182,850,189,463,1129,1185,541,546,1159,314,137,479,59,841,514,548,496,642,341,151,999,1036,1186,704,550,1039,723,779,584,382,371,712,176,665,180,440,697,1102,408,728,157,1050,558,692,336,384,107,839,477,204,862,345,429,1144,1069,207,449,594,963,988,843,334,200,865,281,296,1040,914,995,743,1134,1050,484,602,1001,570,1052,1106,922,77,1099,681,360,955,1184,669,411,760,46,599,815,231,86,694,469,1079,1161,1105,519,1010,681,603,376,534,145,361,448,1006,91,397,671,597,238,119,467,587,723,162,804,638,568,195,460,610,868,806,995,1178,490,406,933,232,17,37,2,114,1004,871,531,209,267,37,750,1196,940,89,725,377,898,6,685,210,1127,1160,432,391,931,681,937,275,1190,137,743,652,430,566,180,1192,718,253,133,998,1067,764,747,1159,827,143,506,641,327,468,731,50,15,569,80,310,1086,1092,989,245,520,711,788,1144,938,1152,1169,563,1053,1182,331,838,112,361,1049,717,979,956,434,534,1083,117,280,1104,293,1137,592,1019,606,526,216,924,197,137,1041,2,910,274,1178,267,521,626,764,691,124,446,337,676,325,288,1120,924,512,777,1063,979,86,677,1183,777,418,41,852,929,712,1132,1030,339,943,475,851,340,894,1091,230,654,229,945,69,182,110,255,895,645,1061,793,1016,807,440,330,519,73,108,660,209,1077,1191,938,415,1162,579,258,14,273,561,834,371,134,1118,1139,1163,667,979,483,436,42,593,139,846,875,571,808,76,713,1198,352,299,156,793,509,245,697,1106,236,287,236,644,683},
////                new int[]{487,13,943,31,661,656,690,175,1147,760,96,290,755,504,1111,219,187,641,380,886,781,214,714,594,41,1154,908,977,1183,28,464,524,895,1177,28,225,1180,206,387,25,166,207,394,418,771,719,153,836,970,589,114,67,1180,1136,863,1144,21,9,957,861,981,849,1031,361,541,649,220,718,263,390,24,830,103,955,233,1174,521,580,83,869,321,712,1011,130,297,835,406,543,849,681,337,355,867,863,552,883,155,762,982,129,605,125,1111,442,89,1139,1084,870,183,1142,78,12,893,677,817,348,1036,482,76,619,563,435,529,311,1148,629,786,288,112,995,854,844,1002,948,570,736,1088,354,618,876,926,150,1108,412,707,233,137,775,751,1137,481,349,150,518,1165,191,223,754,419,1025,817,1001,278,692,403,1023,106,78,124,679,598,727,1026,966,564,726,1148,643,806,1182,645,300,867,613,458,844,679,907,437,1012,902,18,843,190,43,705,818,957,146,1175,130,744,941,975,692,1066,541,335,20,311,606,377,558,113,545,1115,228,29,2,1180,331,1072,151,692,1156,347,293,1135,959,865,1031,40,425,1191,1178,87,989,92,1186,1072,105,1058,369,401,1117,220,484,181,901,321,923,263,72,685,820,1123,736,942,37,419,631,545,761,227,230,25,636,1048,834,736,899,530,217,669,278,653,657,857,724,782,146,780,615,1156,751,463,625,707,355,92,718,855,624,504,359,744,793,868,462,985,1087,517,886,83,221,383,601,709,683,1097,544,411,28,1129,781,13,752,347,1150,1030,269,701,658,658,1188,222,1160,480,953,203,132,17,723,927,911,448,977,1126,219,118,1033,919,1041,712,930,963,772,264,523,479,735,919,72,1019,131,15,628,331,408,578,37,1123,125,527,887,54,1043,259,654,557,872,505,700,1077,202,368,628,29,66,199,611,730,1108,682,705,628,1001,705,21,266,428,1093,800,742,701,715,845,1151,300,460,1134,708,443,706,819,296,199,671,452,626,386,569,999,326,1081,202,384,783,541,811,1058,684,146,288,1149,480,0,658,547,773,588,758,189,489,257,436,362,417,180,671,141,657,864,808,1026,504,827,1125,977,1161,699,360,689,520,796,147,746,978,833,82,102,254,736,88,525,1037,659,1061,333,663,520,6,439,823,1151,395,188,32,513,34,805,1017,1193,157,942,87,630,915,807,215,482,1132,23,1008,1175,724,1070,339,1139,22,455,306,369,151,1031,1119,846,1195,49,1169,773,706,45,747,875,944,1161,1025,258,765,1039,459,641,1169,211,894,556,253,831,1115,458,351,1138,58,1169,1190,743,611,392,1015,54,831,330,1138,681,1012,750,967,1179,398,564,5,2,143,787,197,590,144,589,588,493,524,748,1123,707,585,641,293,871,331,1173,280,218,931,11,663,1005,1118,555,1000,699,720,81,527,71,458,462,1056,447,491,1068,1078,842,455,497,959,745,654,1011,939,787,430,535,594,940,1176,656,207,815,1133,610,1113,596,1018,961,840,555,582,1187,828,161,983,686,870,800,525,34,1013,385,870,953,59,518,521,151,633,561,848,310,712,108,1148,446,480,983,110,442,182,119,463,909,690,48,1040,631,17,1027,158,353,108,524,335,1046,514,1027,746,917,378,437,606,829,743,462,1013,525,290,477,749,896,12,351,13,42,819,334,912,30,1041,815,307,1138,168,209,1134,100,276,292,283,1074,123,561,857,92,879,58,706,532,75,49,385,342,887,646,301,54,483,589,1084,1092,178,845,243,873,611,340,712,115,157,63,773,800,844,167,384,522,877,183,368,709,501,905,512,756,246,197,463,47,232,256,37,883,1048,774,431,943,868,111,163,336,648,313,858,536,416,680,951,320,499,199,234,482,529,676,26,1180,721,877,586,628,1152,835,1145,447,763,750,188,1169,596,1125,310,519,1165,488,1063,59,292,701,1078,1088,663,512,172,477,187,215,1192,22,827,279,607,286,179,744,569,500,510,1038,570,1159,520,1070,759,831,906,644,753,574,257,983,1023,227,460,710,169,595,249,111,73,991,933,448,655,559,183,244,44,644,935,466,97,605,460,800,229,977,675,236,946,73,456,623,499,423,162,342,914,386,1082,407,954,1081,1099,142,539,416,791,1195,1099,885,965,971,796,1198,449,768,792,541,18,476,303,137,319,1008,343,733,128,641,709,175,691,227,307,1177,1198,1075,747,944,1038,933,643,613,1166,1153,120,288,1167,246,1103,185,85,1008,1060,1051,421,150,601,376,183,1028,146,297,515,688,886,1090,552,969,903,1086,931,946,1099,546,17,851,908,1170,418,94,61,233,1069,510,783,302,701,564,1195,57,1007,994,205,1019,694,1020,137,1041,803,673,1162,14,904,418,1076,514,79,944,242,491,867,934,40,1059,776,817,468,516,550,906,790,459,273,924,185,1183,337,435,699,316,768});
//        out.print(maximizedCapital);

//        List<List<Integer>> wall = new ArrayList<>();
//        List<Integer> w = new ArrayList<>();
//        w.add(1);
//        w.add(2);
//        w.add(3);
//        w.add(4);
//        wall.add(w);
//        _554_BrickWall b = new _554_BrickWall();
//        int i = b.leastBricks(wall);

//        _556_NextGreaterElementIII n = new _556_NextGreaterElementIII();
//        int i = n.nextGreaterElement(1234);
//        out.print(i);


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

//        _14_LongestCommonPrefix l = new _14_LongestCommonPrefix();
//        String s = l.longestCommonPrefix(new String[]{"c", "c","c"});
//        out.print(s);

//        _11_ContainerWithMostWater c = new _11_ContainerWithMostWater();
//        int i = c.maxArea(new int[]{1, 1});
//        out.print(i);

//        _532_KDiffPairsInAnArray k = new _532_KDiffPairsInAnArray();
//        int pairs = k.findPairs1(new int[]{3, 1, 4, 1, 5}, 2);
//        out.print(pairs);

//        MinimumCoinChange m = new MinimumCoinChange();
//        int change = m.change1(10, new int[]{1, 2, 3});
//        out.print(change);

//        _10_RegularExpressionMatching r = new _10_RegularExpressionMatching();
//        boolean match = r.isMatch("aab", "c*a*b");
//        out.print(match);

//        _60_PermutationSequence p = new _60_PermutationSequence();
//        String permutation = p.getPermutation(3, 2);
//        out.print(permutation);

//        _33_SearchInRotatedSortedArray s = new _33_SearchInRotatedSortedArray();
//        int search = s.search(new int[]{1}, 1);
//        out.print(search);

//        _17_LetterCombinationsOfAPhoneNumber l = new _17_LetterCombinationsOfAPhoneNumber();
//        List<String> strings = l.letterCombinations("2");
//        out.print(strings);

//        _6_ZigZagConversion z = new _6_ZigZagConversion();
//        String ab = z.convert("ABcd", 3);
//        out.print(ab);

//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//
//        _2_AddTwoNumbers a = new _2_AddTwoNumbers();
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
//        _94_BinaryTreeInorderTraversal b = new _94_BinaryTreeInorderTraversal();
//        List<Integer> integers = b.inorderTraversal(root);
//
//        out.print(integers);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        _92_ReverseLinkedListII r = new _92_ReverseLinkedListII();
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

//        _29_DivideTwoIntegers d = new _29_DivideTwoIntegers();
//        int divide = d.divide(100, 5);
//        out.println(divide);

//        _4_MedianOfTwoSortedArrays m = new _4_MedianOfTwoSortedArrays();
//        double medianSortedArrays3 = m.findMedianSortedArrays3(new int[]{ 5}, new int[]{1,2, 3, 4, 6, 7, 8, 9});
//        out.print("result: " + medianSortedArrays3);

//        AddStrings a = new AddStrings();
//
//        String s = a.addStrings("1", "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//        out.print(s);
//        _377_CombinationSumIV c = new _377_CombinationSumIV();
//        int i = c.combinationSum4(new int[]{1, 2, 3}, 4);
//        out.print(i);

//        _482_LicenseKeyFormatting l = new _482_LicenseKeyFormatting();
//        String aaaa = l.licenseKeyFormatting("2-4A0r7-4k", 4);
//        out.print(aaaa);

//        Combinations c = new Combinations("wxyz");
//        c.combine();

//        Permucations p = new Permucations("abcd");
//        p.permute();

//        _239_SlidingWindowMaximum s = new _239_SlidingWindowMaximum();
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
//        _496_NextGreaterElementI n = new _496_NextGreaterElementI();
//        int[] ints = n.nextGreaterElement(nums1, nums2);
//        out.print(Arrays.toString(ints));


//        String e = "-1/2+1/2";
//        String e = "1/3-1/2";
//        _592_FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new _592_FractionAdditionAndSubtraction();
//        String s = fractionAdditionAndSubtraction.fractionAddition(e);
//        out.print(s);

//        int[] nums = {1, 2, 3, 4};
//        _238_ProductOfArrayExceptSelf productOfArrayExceptSelf = new _238_ProductOfArrayExceptSelf();
//        int[] ints = productOfArrayExceptSelf.productExceptSelf(nums);
//        out.print(Arrays.toString(ints));
//        String s ="tree";
//        _451_SortCharactersByFrequency sortCharactersByFrequency = new _451_SortCharactersByFrequency();
//        String s1 = sortCharactersByFrequency.frequencySort(s);
//        out.print(s1);

//        TreeNode root = new TreeNode(5);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(-5);
//        root.left = root2;
//        root.right = root3;
//
//        _508_MostFrequentSubtreeSum mostFrequentSubtreeSum = new _508_MostFrequentSubtreeSum();
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
//        _515_FindLargestValueInEachTreeRow findLargestValueInEachTreeRow = new _515_FindLargestValueInEachTreeRow();
//        List<Integer> integers = findLargestValueInEachTreeRow.largestValues(root);
//
//        out.print(integers);


//        int[] a = {1, 2, 3, 4,5,6};
//        _413_ArithmeticSlices arithmeticSlices = new _413_ArithmeticSlices();
//        int i = arithmeticSlices.numberOfArithmeticSlices(a);
//        out.print(i);

//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        _406_QueueReconstructionByHeight queueReconstructionByHeight = new _406_QueueReconstructionByHeight();
//        int[][] ints = queueReconstructionByHeight.reconstructQueue(people);
//
//        for (int i = 0; i < ints.length; i++) {
//            out.println(Arrays.toString(ints[i]));
//        }


//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        _480_SlidingWindowMedian slidingWindowMedian = new _480_SlidingWindowMedian();
//        double[] doubles = slidingWindowMedian.medianSlidingWindow(nums, 3);
//        out.print(Arrays.toString(doubles));

//        _513_FindBottomLeftTreeValue.TreeNode node = new _513_FindBottomLeftTreeValue.TreeNode(2);
//        node.left = new _513_FindBottomLeftTreeValue.TreeNode(1);
//        node.right = new _513_FindBottomLeftTreeValue.TreeNode(3);
//        _513_FindBottomLeftTreeValue findBottomLeftTreeValue = new _513_FindBottomLeftTreeValue();
//        int bottomLeftValue = findBottomLeftTreeValue.findBottomLeftValue(node);
//
//        out.print(bottomLeftValue);

//        _338_CountingBits countingBits = new _338_CountingBits();
//        int[] ints = countingBits.countBits(8);
//
//        out.print(Arrays.toString(ints));


//        _535_EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new _535_EncodeAndDecodeTinyURL();
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
