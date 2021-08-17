package com.chenc.leetcode.java9;

public class Main {
    public static void main(String[] args) {
        System.out.println(is_huiwen2(1235321));
    }

    public static boolean is_huiwen2(int x){
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        int end_index = s.length()-1;
        int start_index = 0;
        while(start_index<end_index){
            if(s.charAt(start_index)!=s.charAt(end_index)){
                return false;
            }
            start_index +=1;
            end_index -=1;
        }
        
        return true;
    }

    public static boolean is_huiwen(int x) {
        String new_s = null;
        String s = String.valueOf(x);
        int length = s.length();
        if(length % 2 == 0){
            new_s = s.substring(0, (length/2))+"#"+s.substring((length/2),length);
        }
        else{new_s = s;}
        int middle_index = new_s.length() / 2;
        for(int i=1; i<=new_s.length() / 2; i++){
            if(new_s.charAt(middle_index-i)!=new_s.charAt(middle_index+i)){
                return false;
            }
        }
        return true;
    }
    
}