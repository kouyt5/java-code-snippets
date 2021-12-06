package com.chenc.leetcode.strings.norepeat;

public class Solution2 {

    public static int solution(String s) {

        if (s.length() == 0)
            return 0;
        int maxWindows = 1;
        int startPoint = 0;
        int endPoint = 0;
        int currentWindows = 1;

        for (int i = endPoint; i < s.length() - 1; i++) {
            // 求下一个字符是否在子串里面,在里面就把指针前移动
            for (int j = startPoint; j <= endPoint; j++) {
                if (s.charAt(j) == s.charAt(i + 1)) {
                    startPoint = j + 1;
                    break;
                }
            }
            endPoint += 1;
            currentWindows = endPoint - startPoint + 1;
            if (currentWindows > maxWindows)
                maxWindows = currentWindows;
        }

        return maxWindows;
    }

    public static void main(String[] args) {
        System.out.println(solution("ababc"));
        System.out.println(solution(" "));
        System.out.println(solution("aa"));
        System.out.println(solution("ab"));
        System.out.println(solution("ababc"));
    }
}
