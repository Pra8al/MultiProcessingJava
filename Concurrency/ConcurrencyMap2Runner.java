package Concurrency;


import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrencyMap2Runner {
    public static void main(String[] args) {
        ConcurrentHashMap<Character, LongAdder> occurances = new ConcurrentHashMap<>();

        String str = "ABCD ABCD ABCD";

        for(char charcter : str.toCharArray()){
            occurances.computeIfAbsent(charcter, ch -> new LongAdder()).increment();
        }
        System.out.println(occurances);
        //This is Thread Safe
    }
}
