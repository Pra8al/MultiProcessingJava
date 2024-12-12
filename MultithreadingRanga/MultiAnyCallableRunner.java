package MultithreadingRanga;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> callableTasks = List.of(new CallableTask("Prabal"), new CallableTask("Range"), new CallableTask("Me"));
        String results = executorService.invokeAny(callableTasks);
        System.out.println(results);

        executorService.shutdown();
    }
}
