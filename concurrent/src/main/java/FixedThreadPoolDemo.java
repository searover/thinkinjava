import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by searover on 4/29/16.
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i ++){
            executorService.execute(new RunnerDemo());
            System.out.println("i == " + i);
        }
//        Thread.sleep(60 * 1000);
        executorService.shutdown();
    }
}
