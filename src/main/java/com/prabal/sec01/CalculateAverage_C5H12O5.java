package com.prabal.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculateAverage_C5H12O5 {

    private static final Logger logger = LoggerFactory.getLogger(CalculateAverage_C5H12O5.class);

    public static void main(String[] args) {
        var processors = Runtime.getRuntime().availableProcessors();

//        var builder = Thread.ofPlatform().name("Th", 1);
//
//        for (int i = 1; i <= processors; i++) {
//            Thread thread = builder.unstarted(() -> {
//                logger.info("API Call");
//            });
//            thread.start();
//        }

        for (int i = 1; i <= processors; i++) {
            Thread thread = new Thread(() -> {
                logger.info("API Call");
            });
            thread.start();
        }




    }
}