import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by searover on 4/29/16.
 */
public class CustomRunnable implements Runnable{
    private int id;
    private Future<String> future;

    public CustomRunnable(int id, Future<String> future) {
        this.id = id;
        this.future = future;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + id + " execute complete, result: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
