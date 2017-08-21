package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/17.
 */
public class _400_NthDigit {

    // 1 9  has 1 digit, so  ( 9 - 1 +1 ) * 1 = 9* 10^0 * 1 = 9
    //10 to 99  has 2 digit, so (99 - 10 +1) * 2 = 9 * 10^1 *2 = 180
    //100 to 999 has 3 digit, so (999 - 100 +1 ) * 3 = 9*10^3 *3 = 2700
    // 1000 to 9999 has 4 digit, so (9999 - 1000 + 1) * 4 = 9*10^4 * 4 = 36000
    // ...                   9 * 10^(n-1) * n

    public int findNthDigit(int n) {
        int digitType = 1;
        long digitNum = 9;
        //get the number of digits of target number
        while (n > digitType * digitNum) {
            n -= (int) digitType * digitNum;
            digitType++;
            digitNum *= 10;
        }
        //get location in sub range
        int indexInSubRange = (n - 1) / digitType;
        int indexInNum = (n - 1) % digitType;

        int num = (int) Math.pow(10, digitType - 1) + indexInSubRange;
        char res = Integer.toString(num).charAt(indexInNum);
        return res - '0';
    }

    //思路：可以分三步来做：
    //１．找出给定的n落在几位数的范围内
    //２．找到具体落在哪个数字
    //３．找出具体在哪一位上

    // 分析可以得出一位有９个数字，二位数有90个数字，三位数有900个数，依次类推．因此可以每次增加一位数字，
    // 看n是否还在这个范围内．例如给定n = 150，首先一位有９个数字，所以位数可以＋１，这样n-9 = 141.
    // 然后２位的数字有２＊９０= 180，大于１４１，所以目标数字肯定是２位的．
    // 然后求具体落在哪个数字．可以用10+(141-1)/2 = 80求出．
    // 再求具体落在哪一位上，可以用(141-1)%2＝０求出为第０位，即８．如此即可．

    public int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public int findNthDigit2(int n) {
        if (n <= 0) {
            return 0;
        }
        long len = 1;
        long count = 9;
        long num = 1;
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            num *= 10;
        }
        num += (n - 1) / len;
        String numStr = String.valueOf(num);
        //System.out.println(numStr);
        // return Character.getNumericValue(numStr.charAt((n - 1) % len));
        return numStr.charAt((int) ((n - 1) % len)) - '0';
    }
}
