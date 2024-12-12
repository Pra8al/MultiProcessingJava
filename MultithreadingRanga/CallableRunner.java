package MultithreadingRanga;

import java.util.concurrent.*;

class CallableTask implements Callable<String>{

    private String name;

    public CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello "+name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> prabal = executorService.submit(new CallableTask("Prabal"));
        System.out.println("new CallableTask(\"Prabal\") executed");
        System.out.println(prabal.get());
        System.out.println("Main completed");
        executorService.shutdown();

    }
}
