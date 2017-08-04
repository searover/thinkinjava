import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by searover on 4/29/16.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();
        // Create 10 jobs and execute
        for (int i = 0; i < 10; i++) {
            try {
                Future<String> future = executorService.submit(new TaskWithResult(i));
                resultList.add(future);
                executorService.shutdown();
            } catch (Exception e) {
                System.out.println("id: " + i + ", rejected.");
//                continue;
            }
        }
        for (Future<String> future : resultList) {
            System.out.println(future.get());
        }
    }
}
