package com.chenc.leetcode.strings.count_number;

class Solution {
    long[][] nums = new long[2][100000];
    public int countTexts(String pressedKeys) {
        int j = 1;
        long total = 1;
        for (int i = 1;i<pressedKeys.length();i++){
            char curr = pressedKeys.charAt(i);
            if (pressedKeys.charAt(i-1) == curr){
                j += 1;
                continue;
            }
            if (pressedKeys.charAt(i-1) == '9' || pressedKeys.charAt(i-1) == '7'){
                total = total * dp(j, 4) ;
            }else{
                total = total * dp(j, 3);
            }
            total = total % 1000000007;
            j = 1;
        }
        if (j > 1){
            if (pressedKeys.charAt(pressedKeys.length()-1) == '9' || pressedKeys.charAt(pressedKeys.length()-1) == '7'){
                total = total * dp(j, 4);
            }else{
                total = total * dp(j, 3);
            }
            total = total % 1000000007;
        }

        return (int)total;
    }

    public long dp(int n, int length){
        if (n < 0) return 0;
        if (n <= 1){
            return 1;
        }
        if (nums[length-3][n] != 0) return nums[length-3][n];
        long res = 0;
        if (length == 3){
            res = dp(n-1,3) + dp(n-2,3) + dp(n-3,3);
        }else{
            res = dp(n-1, 4) + dp(n-2,4) + dp(n-3,4) + dp(n-4,4);
        }
        nums[length-3][n] = res % 1000000007;
        return res % 1000000007;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "8888888888888888888888888888899999999999999999999999999999444444444444444444444444444448888888888888888888888888888855555555555555555555555555555";
        solution.countTexts(s);
        s = s + "6666666666666666666666666666666666666666666666666666666666";
        
        solution.countTexts(s);
    }
}
