package com.chenc.tmp;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InnerClassTest {
    
    private int ageOut;

    private class Inner{
        private int age;
        public String name;

        public Inner(){
            this.age = 1;
            this.name = "inner";
            ageOut = 2;
            System.out.print(ageOut);
        }
    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        Inner inner = innerClassTest.new Inner();
        System.out.print("obj");
        AtomicInteger atomicInteger = new AtomicInteger(1);
    }
}
