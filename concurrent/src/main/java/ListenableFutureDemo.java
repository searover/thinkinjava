import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by searover on 4/29/16.
 */
public class ListenableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        List<Future<String>> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            ListenableFuture future = listeningExecutorService.submit(new TaskWithResult(i));
            future.addListener(new CustomRunnable(i,future),executorService);
            resultList.add(future);
        }
        for (Future<String> future : resultList){
            String re = future.get();
        }
        executorService.shutdown();
    }
}
