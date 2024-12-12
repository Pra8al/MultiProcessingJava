package MultithreadingRanga;

/*
States of thread:
 1. NEW
 2. RUNNABLE
 3. RUNNING
 4. BLOCK/WAITING
 5. TERMINATED/DEAD
 */
class Task1 extends Thread{
    public void run(){
        System.out.println("\nTask 1 Started");
        for(int i= 101; i<199 ; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 1 Done");
    }
}

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask 2 Started");
        for(int i= 201; i<299 ; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 2 Done");
    }
}



public class ThreadBasicRunner {

    public static void main(String[] args) {
        //Threads allow tasks to be executed in parallel whenever CPU is available
        /*
         * There are two ways to create threads
         * 1. extends Thread
         * 2. implements Runnable
         */
        //Task 1
        System.out.println("\nTask 1 Kicked Off");
        Task1 task1 = new Task1();
        task1.start(); //Don't use run here thread will only start when using start method
        //Task 2
        System.out.println("\nTask 2 Kicked Off");
        Task2 task2 = new Task2();
        Thread threadtask2 = new Thread(task2); //Remember this extra step
        threadtask2.start();

        //Task 3
        for(int i= 301; i<399 ; i++)
            System.out.print(i + " ");
        System.out.println("\nTask 3 Done");
        System.out.println("\nMain Done");

    }
}
