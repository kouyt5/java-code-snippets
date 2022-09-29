package com.chenc.tmp;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CulTest {
    public static void main(String[] args) {
        
        // long x = 100L;
        // int y = 11;
        // System.out.println(x/y);
        get2();
    }

    public static void get2() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
        runThread(blockingQueue);
        for (int i=0;i<1000;i++) {
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void runThread(BlockingQueue<Integer> queue){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        System.out.println("take one" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread rThread = new Thread(runnable);
        rThread.start();

    }
    public static void get() {
        int[] src = new int[]{
            1,2,3,4,5,6,7,8
        };
        long pre_time = System.currentTimeMillis();
        for (int i = 0;i<90000000;i++) {
            int[] dest = new int[src.length];
            System.arraycopy(src, 0, dest, 0, src.length);

            // for (int j = 0;j<dest.length;j++) {
            //     dest[j] = src[j];
            // }

            dest = Arrays.copyOf(src, src.length);
        }
        System.out.println(System.currentTimeMillis() - pre_time);
    }


}
