package com.test.leetcode.easy;

/**
 * Created by ben on 2017/6/15.
 */
public class _415_AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i > -1 && j > -1) {
            int sum = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        while (i > -1) {
            int sum = Character.getNumericValue(num1.charAt(i)) + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
        }
        while (j > -1) {
            int sum = Character.getNumericValue(num2.charAt(j)) + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            j--;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += num2.charAt(i) - '0';
                j--;
            }
            result = carry % 10 + result;
            carry = carry / 10;
        }
        return result;
    }

}
