package MultithreadingRanga;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.List.of;

public class MultiCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTasks = List.of(new CallableTask("Prabal"), new CallableTask("Range"), new CallableTask("Me"));
        List<Future<String>> results = executorService.invokeAll(callableTasks);
        for (Future<String> result:results){
            System.out.println(result.get());
        }

        executorService.shutdown();
    }
}
