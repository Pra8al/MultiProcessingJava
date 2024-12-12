package MultithreadingRanga;

public class ThreadRunner {
    public static void main(String[] args) {
        //Threads allow tasks to be executed in parallel whenever CPU is available
        /*
         * There are two ways to create threads
         * 1. extends Thread
         * 2. implements Runnable
         */
        //Task 1
    for(int i= 101; i<199 ; i++)
        System.out.print(i + " ");
        System.out.println("\nTask 1 Done");
        //Task 2
        for(int i= 201; i<299 ; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 2 Done");

        //Task 3
        for(int i= 301; i<399 ; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 3 Done");
        System.out.println("\nMain Done");

    }
}
