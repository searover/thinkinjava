import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
    public static void main(String[] args) throws InterruptedException {
        new Timer(true).schedule(new MyTimerTask(), 0, 200);
        int second = 1;
        while (true){
            System.out.println(second++);
            Thread.sleep(1000);
        }
    }

    private static int count = 0;

    static class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Bombing!!!");
        }
    }
}
