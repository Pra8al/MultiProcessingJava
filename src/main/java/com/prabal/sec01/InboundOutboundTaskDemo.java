package com.prabal.sec01;

public class InboundOutboundTaskDemo {

    private static final int MAX_PLATFORM = 10_000;

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

    public static void main(String[] args) {
        platformThreadDemo1();
    }
}
