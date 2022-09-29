package com.chenc.tmp.sub;

public class Base {
    public int test(){
        return 0;
    }

    static {
        System.out.println("Father Static");
    }
    public Base() {
        System.out.println("Base");
    }
}
