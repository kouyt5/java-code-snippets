package com.chenc.jdkin.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.chenc.tmp.Test;

public class Main {
    public static void main(String[] args) {
        Test test = new Test() {
            @Override
            public void test() {
                System.out.println("test in");
            }
        };

        Test proxy = (Test) Proxy.newProxyInstance(
                test.getClass().getClassLoader(),
                test.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy before");
                        Object object = method.invoke(test, args);
                        return null;
                    }
                });
        proxy.test();
    }

    static interface Test {
        public void test();
    }
}