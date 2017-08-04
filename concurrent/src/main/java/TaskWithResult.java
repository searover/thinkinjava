import java.util.concurrent.Callable;

/**
 * Created by searover on 4/29/16.
 */
public class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Call 方法被调用," + Thread.currentThread().getName());
        Thread.sleep(1000);
        return "Call execute complete, id: " + id + ", " + Thread.currentThread().getName();
    }
}
