package MultithreadingRanga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Task1());
        executorService.execute(new Thread(new Task2()));


        //Task 3
        for (int i = 301; i < 399; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 3 Done");
        System.out.println("\nMain Done");

        executorService.shutdown();
    }

}
