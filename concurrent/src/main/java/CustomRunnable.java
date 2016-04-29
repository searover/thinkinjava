/**
 * Created by searover on 4/29/16.
 */
public class CustomRunnable implements Runnable{
    private int id;

    public CustomRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " execute complete.");
    }
}
