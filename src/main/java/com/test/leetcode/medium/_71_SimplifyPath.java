package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/8.
 */
public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        if (null == path || path.length() == 0) return path;

        int len = path.length();
        List<String> list = new ArrayList<>();
        int i = 0;
        if (path.charAt(i) == '/') {
            i = 1;
        }
        int lastIdx = i;
        String temp;
        for (; i < len; i++) {
            if (path.charAt(i) != '/') {
                continue;
            }
            temp = path.substring(lastIdx, i);
            lastIdx = i + 1;
            if(temp.length()==0) continue;
            switch (temp) {
                case ".":
                    break;

                case "..":
                    if (list.size() > 0)
                        list.remove(list.size() - 1);
                    break;

                default:
                    list.add(temp);
            }
        }
        if (lastIdx != i) {
            temp = path.substring(lastIdx, i);
            switch (temp) {
                case ".":
                    break;

                case "..":
                    if (list.size() > 0)
                        list.remove(list.size() - 1);
                    break;

                default:
                    list.add(temp);
            }
        }

        if (list.size() == 0) return "/";

        StringBuilder sb = new StringBuilder();
        sb.append('/');

        for (i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append('/');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
