package com.chenc.leetcode.java12;

public class Main {
  public static void main(String[] args) {
      System.out.println(romaString(12));
  }  


  /**
   * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * @param x
   * @return 罗马数字字符串
   */
  public static String romaString(int x){
    int remain_x = x;
    int count_M = remain_x / 1000; remain_x = remain_x % 1000;
    int count_CM = remain_x / 900; remain_x = remain_x % 900; // CM
    int count_D = remain_x / 500; remain_x = remain_x % 500;
    int count_CD = remain_x / 400; remain_x = remain_x % 400; // CD
    int count_C = remain_x / 100; remain_x = remain_x % 100;
    int count_XC = remain_x / 90; remain_x = remain_x % 90; // XC
    int count_L = remain_x / 50; remain_x = remain_x % 50;
    int count_XL = remain_x / 40; remain_x = remain_x % 40; // XL
    int count_X = remain_x / 10; remain_x = remain_x % 10;
    int count_IX = remain_x / 9; remain_x = remain_x % 9; // IX
    int count_V = remain_x / 5; remain_x = remain_x % 5;
    int count_IV = remain_x / 4; remain_x = remain_x % 4; // IV
    int count_I = remain_x;
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(getCountString(count_M, 'M'));
    if(count_CM>0){sBuilder.append("CM");}
    sBuilder.append(getCountString(count_D, 'D'));
    if(count_CD>0){sBuilder.append("CD");}
    sBuilder.append(getCountString(count_C, 'C'));
    if(count_XC>0){sBuilder.append("XC");}
    sBuilder.append(getCountString(count_L, 'L'));
    if(count_XL>0){sBuilder.append("XL");}
    sBuilder.append(getCountString(count_X, 'X'));
    if(count_IX>0){sBuilder.append("IX");}
    sBuilder.append(getCountString(count_V, 'V'));
    if(count_IV>0){sBuilder.append("IV");}
    sBuilder.append(getCountString(count_I, 'I'));
    return sBuilder.toString();
  }

  public static String getCountString(int count, char c){
    if(count ==0){
        return "";
    }
    StringBuilder sb = new StringBuilder();
    while(count > 0){
        sb.append(c);
        count -=1;
    }
    return sb.toString();
  }
}