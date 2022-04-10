package com.chenc.leetcode.strings.convert2int;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public int strToInt(String str) {
        if (str.length()==0) return 0;
        int i = 0;
        while (i<str.length()-1&&str.charAt(i)==' '){
                i++;
        }
        // i 为第一个非' '字符index
        boolean flag = true;
        if (str.charAt(i) == '+'){
            flag = true;
            i++;
        }
        else if (str.charAt(i) == '-'){
            flag = false;
            i++;
        }
        // 如果第一个为整数
        if (i<str.length()&&str.charAt(i) <= '9'&& str.charAt(i)>='0'){
            int j = i;
            while(j<str.length()&&str.charAt(j) <= '9'&& str.charAt(j)>='0'){
                j++;
            }
            int k = i;
            while (k<j&&str.charAt(k) == '0'){
                k++;
            }
            if (k == j) return 0;
            String s = str.substring(k, j);
            if (flag&&s.length()==10&&s.compareTo("2147483647")>=0){
                return 2147483647;
            }else if (!flag&&s.length()==10&&s.compareTo("2147483648")>=0){
                return -2147483648;
            }else if(!flag&&s.length()>10) {
                return -2147483648;
            }else if (flag&&s.length()>10){
                return 2147483647;
            }
            return flag?Integer.parseInt(s):-Integer.parseInt(s);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.strToInt("-2147483648");
        List< Integer> s = new ArrayList<>();
    }
}
