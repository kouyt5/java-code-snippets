package com.chenc.interview.tenxun;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[][] nums = new long[n][];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            nums[i] = new long[line.length()];
            for (int j = 0; j < line.length(); j++) {
                nums[i][j] = line.charAt(j) - '0';
            }
        }
        //
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums[0].length; i++) {
            String res = "";
            for (int j = 0; j < n; j++) {
                res += nums[j][i];
            }
            if (res.length() == 0)
                res = "0";
            ans.add(res);
        }
        Collections.sort(ans);
        String tmp = "";
        for (String i : ans) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<i.length();j++){
                if (!flag && i.charAt(j)=='0'){
                    continue;
                }
                if (i.charAt(j)!='0'){
                    flag = true;
                }
                sb.append(i.charAt(j));
            }
            if (sb.length() == 0){
                sb.append('0');
            }
            tmp += sb.toString()+" ";
        }
        System.out.println(tmp.trim());
    }
}