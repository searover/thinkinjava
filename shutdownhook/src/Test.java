/**
 * Created by searover on 5/16/16.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start.......");
        Thread.sleep(5*1000);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("Shutdown hook");
                System.out.println("Shutdown hook");
                System.out.println("Shutdown hook");
                System.out.println("Shutdown hook");
                System.out.println("Shutdown hook");
            }
        });
    }
}
