package com.test.leetcode.hard;

import java.util.*;

/**
 * Created by ben on 2017/7/18.
 */
public class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (null == s || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        if (words.length > s.length()) {
            return result;
        }
        if (words[0].length() > s.length()) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            int i = map.getOrDefault(w, 0) + 1;
            map.put(w, i);
        }
        int len = words[0].length();
        int end1 = s.length() - len * words.length + 1;
        String str;
        boolean found;
        Map<String, Integer> temp = new HashMap<>();
        int start, end;
        for (int i = 0; i < end1; i++) {
            temp.clear();
            str = s.substring(i, i + len);
            if (map.get(str) != null) {
                temp.put(str, 1);
                found = true;
                for (int j = 1; j < words.length; j++) {
                    start = i + j * len;
                    end = start + len;
                    str = s.substring(start, end);
                    Integer b = map.get(str);
                    if (b != null) {
                        int a = temp.getOrDefault(str, 0) + 1;
                        if (a > b) {
                            found = false;
                            break;
                        }
                        temp.put(str, a);
                    } else {
                        found = false;
                    }
                }
                if (found)
                    result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        /**
         * Let n=s.length, k=words[0].length traverse s with indices i, i+k,
         * i+2k, ... for 0<=i<k, so that the time complexity is O(n).
         */
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(), m = words.length, k;
        if (n == 0 || m == 0 || (k = words[0].length()) == 0)
            return res;

        HashMap<String, Integer> wDict = new HashMap<String, Integer>();

        for (String word : words) {
            if (wDict.containsKey(word))
                wDict.put(word, wDict.get(word) + 1);
            else
                wDict.put(word, 1);
        }

        int i, j, start, x, wordsLen = m * k;
        HashMap<String, Integer> curDict = new HashMap<String, Integer>();
        String test, temp;
        for (i = 0; i < k; i++) {
            curDict.clear();
            start = i;
            if (start + wordsLen > n)
                return res;
            for (j = i; j + k <= n; j += k) {
                test = s.substring(j, j + k);

                if (wDict.containsKey(test)) {
                    if (!curDict.containsKey(test)) {
                        curDict.put(test, 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.containsKey(test)
                    x = curDict.get(test);
                    if (x < wDict.get(test)) {
                        curDict.put(test, x + 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.get(test)==wDict.get(test), slide start to
                    // the next word of the first same word as test
                    while (!(temp = s.substring(start, start + k)).equals(test)) {
                        decreaseCount(curDict, temp);
                        start += k;
                    }
                    start += k;
                    if (start + wordsLen > n)
                        break;
                    continue;
                }

                // totally failed up to index j+k, slide start and reset all
                start = j + k;
                if (start + wordsLen > n)
                    break;
                curDict.clear();
            }
        }
        return res;
    }

    public int checkFound(List<Integer> res, int start, int wordsLen, int j, int k,
                          HashMap<String, Integer> curDict, String s) {
        if (start + wordsLen == j + k) {
            res.add(start);
            // slide start to the next word
            decreaseCount(curDict, s.substring(start, start + k));
            return start + k;
        }
        return start;
    }

    public void decreaseCount(HashMap<String, Integer> curDict, String key) {
        // remove key if curDict.get(key)==1, otherwise decrease it by 1
        int x = curDict.get(key);
        if (x == 1)
            curDict.remove(key);
        else
            curDict.put(key, x - 1);
    }


    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.equals("") || words.length == 0 || words == null) return res;
        int lenS = s.length(), lenW = words[0].length(), lenWs = words.length;
        if (lenS < lenW * lenWs) return res;
        int last = lenS - lenW + 1;

        //将words中不同的单词加入map，并用一个辅助数组记录它们各自的出现次数
        int[][] tabel = new int[2][lenWs];
        int index = 0, count = 0;
        Map<String, Integer> mapping = new HashMap<String, Integer>(lenWs);
        for (int i = 0; i < lenWs; i++) {
            Integer value = mapping.get(words[i]);
            if (value == null) {
                ++count;
                mapping.put(words[i], index);
                value = index++;
            }
            ++tabel[0][value];
        }

        //遍历一遍s，用一个辅助数组记录下words里每个字符串出现的位置，-1表示该位置没有出现words里的字符串
        int[] occurances = new int[last];
        for (int i = 0; i < last; i++) {
            String word = s.substring(i, i + lenW);
            Integer value = mapping.get(word);
            if (value == null) occurances[i] = -1;
            else occurances[i] = value;
        }

        //在线性时间里处理整个字符串
        for (int i = 0; i < lenW; i++) {
            int currentCount = count;
            int left = i, right = i;
            Arrays.fill(tabel[1], 0);

            while (right < last) {
                //查找字符串里第一次全部出现了words里的字符串
                while (currentCount > 0 && right < last) {
                    int target = occurances[right];
                    if (target != -1 && ++tabel[1][target] == tabel[0][target]) --currentCount;
                    right += lenW;
                }
                //判断words里出现的字符串是否是连续出现的
                while (currentCount == 0 && left < right) {
                    int target = occurances[left];
                    //--tabel[1][target]是因为left最后要左移
                    if (target != -1 && --tabel[1][target] == tabel[0][target] - 1) {
                        int length = right - left;
                        if (length / lenW == lenWs) res.add(left);
                        ++currentCount;
                    }
                    left += lenW;
                }
            }
        }

        return res;
    }
}
