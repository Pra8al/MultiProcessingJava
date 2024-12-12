package com.prabal.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class InboundOutboundTaskDemo {

    private static final int MAX_PLATFORM = 10;
    private static final int VIRTUAL_THREADS = 10;

    private static final Logger log = LoggerFactory.getLogger(InboundOutboundTaskDemo.class);

    public static void main(String[] args) throws InterruptedException {
        virtualThreadDemo2();
    }


    /*
        To create a simple java platform thread
     */
    private static void platformThreadDemo1() {
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
    To create platform thread using Thread.Builder
    */
    private static void platformThreadDemo2() {
        var builder = Thread.ofPlatform().name("prabal", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
    To create daemon thread using Thread.Builder
    */
    private static void platformThreadDemo3() {
        var builder = Thread.ofPlatform().daemon().name("daemon", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
    To create daemon thread using Thread.Builder and CountDownLatch
    */
    private static void platformThreadDemo4() throws InterruptedException {
        var latch = new CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofPlatform().daemon().name("daemon", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
    }

    /*
    To create virtual thread using Thread.Builder
    */
    private static void virtualThreadDemo1() {
        var builder = Thread.ofVirtual();
        for (int i = 0; i < VIRTUAL_THREADS; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
    To create virtual thread using Thread.Builder
    */
    private static void virtualThreadDemo2() throws InterruptedException {
        var countDownLatch = new CountDownLatch(VIRTUAL_THREADS);
        var builder = Thread.ofVirtual().name("virtual-", 1);
        for (int i = 0; i < VIRTUAL_THREADS; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        log.info("Process Completed");
    }

}
