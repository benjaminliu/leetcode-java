package com.test.leetcode.easy;

import java.util.List;

/**
 * Created by ben on 2017/8/23.
 */
public class _422_ValidWordSquare {
    //Given a sequence of words, check whether it forms a valid word square.

    //A sequence of words forms a valid word square if the kth row and column read the exact same string,
    // where 0 ≤ k < max(numRows, numColumns).

    //Note:
    //The number of words given is at least 1 and does not exceed 500.
    //Word length will be at least 1 and does not exceed 500.
    //Each word contains only lowercase English alphabet a-z.
    //        Example 1:

    //Input:
    //        [
    //        "abcd",
    //        "bnrt",
    //        "crmy",
    //        "dtye"
    //        ]

    //Output:
    //        true

    //Explanation:
    //The first row and first column both read "abcd".
    //The second row and second column both read "bnrt".
    //The third row and third column both read "crmy".
    //The fourth row and fourth column both read "dtye".

    //Therefore, it is a valid word square.

    //Example 2:

    //Input:
    //       [
    //        "abcd",
    //        "bnrt",
    //        "crm",
    //        "dt"
    //        ]

    //Output:
    //        true

    //Explanation:
    //The first row and first column both read "abcd".
    //The second row and second column both read "bnrt".
    //The third row and third column both read "crm".
    //The fourth row and fourth column both read "dt".

    //Therefore, it is a valid word square.
    //Example 3:

    //Input:
    //        [
    //        "ball",
    //        "area",
    //        "read",
    //        "lady"
    //        ]

    //Output:
    //        false

    //Explanation:
    //The third row reads "read" while the third column reads "lead".

    //Therefore, it is NOT a valid word square.

    public boolean validWordSquare(List<String> words) {
        if (null == words || words.size() == 0) return true;

        int len = words.size();
        if (len != words.get(0).length()) return false;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.setLength(0);
            for (String w : words) {
                if (idx < w.length()) {
                    sb.append(w.charAt(idx));
                }
            }
            if (!words.get(i).equals(sb.toString())) return false;
            idx++;
        }
        return true;
    }


    public boolean validWordSquare1(List<String> words) {

        for(int i=0;i<words.size();i++){
            String s = words.get(i);
            if(!s.equals(getVertical(i, words))){
                return false;
            }
        }
        return true;
    }

    private String getVertical(int col,List<String> words){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.size();i++){
            String word = words.get(i);
            if(col<word.length()){
                sb.append(word.charAt(col));
            }
        }
        return sb.toString();
    }

    public boolean validWordSquare2(List<String> words) {
        try{
            for(int row = 0; row <words.size();row++){
                String word = words.get(row);
                for(int col = 0;col<word.length();col++){
                    String word_cmp = words.get(col);
                    if(word.charAt(col) != word_cmp.charAt(row)){
                        return false;
                    }
                }
            }
        }catch(StringIndexOutOfBoundsException e){
            return false;
        }catch(IndexOutOfBoundsException ee){
            return false;
        }
        return true;
    }
}
