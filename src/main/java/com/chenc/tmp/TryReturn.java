package com.chenc.tmp;

public class TryReturn {
    private static int a = 1;
    private static Integer i;
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            return a+1;
        } catch (Exception e) {
            return a+1;
        } finally {
            a += 2;
            System.out.println("finally: " + a);
        }
    }
}
