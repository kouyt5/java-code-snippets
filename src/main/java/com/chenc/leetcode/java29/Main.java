package com.chenc.leetcode.java29;

class Main {
    public static void main(String[] args) {
        System.out.println(solution(-2147483648, -1));
    }

    public static int solution(int x, int y){
        // int to double
        int temp = (int)Math.pow(2, 31)-1;
        double result = (double)x / y;
        if(result>=Math.pow(2, 31)-1.0){
            return (int)(Math.pow(2, 31)-1.0);
        }
        else if(result<-Math.pow(2, 31)){
            return (int)-Math.pow(2, 31);
        }
        return (int)result;
    }
}