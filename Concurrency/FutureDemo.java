package Concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(4);

        Future<Integer> fut = es.submit(() -> {
            System.out.println(Thread.currentThread() + " :first call");
            return 1;
        }); //Non-blocking
        int f1_val = fut.get(); //Blocking code

        Future<Integer> fut2 = es.submit(()-> {
            System.out.println(Thread.currentThread() + ":second call");
            return f1_val+1;
        });
        int f2_val = fut2.get();
        System.out.println(fut.get());
        Future<Integer> fut3 = es.submit(() -> {
            System.out.println(Thread.currentThread() + ":third call");
            return f2_val+1;
        });
        System.out.println(fut3.get());
        es.shutdown();
    }
}
