package com.chenc.interview.ali;

import java.util.*;
import java.math.BigInteger;

public class Main{
    public static void solu(String num){
        //遍历2-16进制
        char[] nums = num.toCharArray();
        List<BigInteger> res = new ArrayList<>();
        for (int i = 2;i<=16;i++){
            BigInteger total = new BigInteger("0");
            for (int j = 0;j<nums.length;j++){
                int base = 1;
                if (nums[j] >=0 && nums[j] <='9'){
                    base = nums[j] - '0';
                    
                }else{
                    base = nums[j] - 'A' + 10;
                }
                if (base+1 > i){
                    break;
                }
                double tmp = Math.pow(i,nums.length-j-1)*base;
                long x = Math.round(tmp);
                BigInteger y = BigInteger.valueOf(x);
                total = total.add(y);
                if (j == nums.length -1){
                    res.add(total);
                }
            }
            
        }
        for (BigInteger i:res){
//             System.out.println(Integer.parseInt(String.valueOf(i)));
            i = i.mod(new BigInteger("1000000007"));
            System.out.println(i.intValue());
        }
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            Main.solu(s);
        }
        
    }
}