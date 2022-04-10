package com.chenc.interview.ant_tuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 小美过冬之前将很多数藏进-个仅包含小写英文字母的字符串。冬天她想将所有数找回来，请帮帮她。
 * 给定一个字符串s,仅包含小写英文字母和数字，找出其中所有数。一个数是指其中一段无法延伸的连续数
 * 字串。如a1254b中仅包含1254这一个数，125则不是， 因为125还可以向右延伸成1254。如果该字符串包
 * 含前导零，则抹掉前导零。例如a0125b1中包含两个数0125和1,按照规则抹掉前导零后，最终这个字符串
 * 包含的两个数为125和1
 * 
 * @author cc
 * @since 2022.3.4
 */
public class Solution2 {
    
    public int[] solution(String s){
        List<Integer> reslut = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)<='9'&&s.charAt(i)>='0'){
                sb.append(s.charAt(i));
            }else{
                if (sb.length() > 0){
                    int num = Integer.parseInt(sb.toString());
                    reslut.add(num);
                    sb.delete(0, sb.length());
                }
            }
        }
        if (!sb.isEmpty()){
            int num = Integer.parseInt(sb.toString());
            reslut.add(num);
        }
        int[] result = new int[reslut.size()];
        for (int j = 0;j<reslut.size();j++){
            result[j] = reslut.get(j);
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.print(solution2.solution("He12l12lo98rr012d"));
    }
}
