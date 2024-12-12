package Concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompleteableFutureDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(()->1, es)
                .thenApplyAsync(CompleteableFutureDemo::addOne,es)
                .thenApplyAsync(CompleteableFutureDemo::addOne,es)
                .thenAcceptAsync(System.out::print,es)
                .thenRunAsync(es::shutdown);

//        CompletableFuture.supplyAsync(()->1, es)
//                .thenApplyAsync(e -> addOne(e),es)
//                .thenAcceptAsync(System.out::print,es)
//                .thenRunAsync(es::shutdown);
    }

    private static Integer addOne(Integer e) {
        return e+1;
    }
}
