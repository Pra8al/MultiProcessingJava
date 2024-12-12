package Concurrency;


import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrencyMapRunner {
    public static void main(String[] args) {
        Map<Character, LongAdder> occurances = new Hashtable<>();

        String str = "ABCD ABCD ABCD";

        for(char charcter : str.toCharArray()){
            LongAdder longAdder = occurances.get(charcter);
            if(longAdder==null){
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurances.put(charcter,longAdder);
        }
        System.out.println(occurances);
        //This is not thread safe though
    }
}
