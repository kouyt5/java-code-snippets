package com.chenc.tmp;

import java.io.EOFException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 测试{@link RuntimeException}
 * @author cc
 * @since 2022.2.17
 */
public class ExceptionTest {

    public static void test(){
        try{
            throw new RuntimeException();
        }catch(RuntimeException e){
            System.out.println(e.toString());
        }catch (Exception e){
            System.out.println("out");
        }

        try{
            throw new MyRuntimeException();
        }catch(RuntimeException e){
            System.out.println(e.toString());
        }catch (Exception e){
            System.out.println("Exception");
        }
        // throw new RuntimeException("ignore");
        throw new MyRuntimeException();
    }
    public static void main(String[] args) {

        // ExceptionTest.test();
        System.out.println("last");
        Map<Integer, Integer> map = new HashMap<>();
        // LinkedList<Integer> tmp = new LinkedList<>();
        // tmp.removeLast();
        // tmp.add(1);
        // List<Integer> tmp = new ArrayList<>();
        // tmp.remove(tmp.size()-1);
        map.put(null, 1);
        System.out.println(map.get(null));
    }

    public static class MyRuntimeException extends RuntimeException{

    }
}
