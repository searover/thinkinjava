public class ThreadLoop {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable(10));
        t1.start();
        Thread.sleep(10);
        new MyRunnable(100).run();
    }
}

class MyRunnable implements Runnable {

    private int count;

    public MyRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (MyRunnable.class) {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + " loop " + (i + 1));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}