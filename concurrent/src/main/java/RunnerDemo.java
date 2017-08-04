/**
 * Created by searover on 4/29/16.
 */
public class RunnerDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t 线程被调用了");
//        while (false){
//            try {
//                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//
//            }
//        }
    }
}
