package Concurrency;

public class Counter {

   private int counter = 0;

//    public void increment(){
//        counter++;
//        //this is not Atomic (Not threadSafe) it has three operations
//        //get
//        //increment
//        //set
//    }
//      Adding synchronized for solution
    synchronized void increment(){
        counter++;

    }
    public int getCounter() {
        return counter;
    }
}
