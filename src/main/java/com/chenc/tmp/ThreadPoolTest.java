package com.chenc.tmp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        executor.execute(new MyRunner());
        executor.execute(new MyRunner());
        Future<String> result = executor.submit(new MyCallable());
        System.out.println(executor.getActiveCount());
        System.out.println(executor.getTaskCount());
        System.out.println(result.get());
        
    }

    public static class MyRunner implements Runnable{

        @Override
        public void run() {
            for (int i = 0;i< 100;i++){
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello world";
        }
        
    }
}
