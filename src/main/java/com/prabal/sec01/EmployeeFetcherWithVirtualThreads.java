package com.prabal.sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmployeeFetcherWithVirtualThreads {
    private static final int CHUNK_SIZE = 100;
    private static final int TOTAL_EMPLOYEES = 30000;

    public static void main(String[] args) throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) { // Virtual thread executor
            var startTime = System.currentTimeMillis();
            List<Future<List<String>>> futures = new ArrayList<>();

            // Divide the workload into chunks
            for (int offset = 0; offset < TOTAL_EMPLOYEES; offset += CHUNK_SIZE) {
                int currentOffset = offset;
                futures.add(executor.submit(() -> fetchEmployees(currentOffset, CHUNK_SIZE)));
            }

            // Collect results
            List<String> allEmployees = new ArrayList<>();
            for (Future<List<String>> future : futures) {
                allEmployees.addAll(future.resultNow()); // Fetch the result as it completes
            }

            var endTime = System.currentTimeMillis();
            System.out.println("Total employees fetched: " + allEmployees.size());
            System.out.println("Time in millis: " + (endTime - startTime));
        }
    }

    private static List<String> fetchEmployees(int offset, int limit) {
        // Simulate API call
        System.out.println("Fetching employees from offset " + offset);
        try {
            Thread.sleep(200); // Simulate network delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        List<String> employees = new ArrayList<>();
        for (int i = offset; i < offset + limit; i++) {
            employees.add("Employee-" + i);
        }
        return employees;
    }
}
