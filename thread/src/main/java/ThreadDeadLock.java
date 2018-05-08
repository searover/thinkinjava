public class ThreadDeadLock {

    public static void main(String[] args) {
        String s1 = "locker-1";
        String s2 = "locker-2";

        Thread t1 = new Thread(new SyncThread(s1, s2), "t1");
        Thread t2 = new Thread(new SyncThread(s2, s1), "t2");

        t1.start();
        t2.start();
    }
}

class SyncThread implements Runnable {
    private String lockerA;
    private String lockerB;

    public SyncThread(String lockerA, String lockerB) {
        this.lockerA = lockerA;
        this.lockerB = lockerB;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + lockerA);
        synchronized (lockerA) {
            System.out.println(name + " acquire success lock on " + lockerA);
            work();
            System.out.println(name + " acquiring lock on " + lockerB);
            synchronized (lockerB) {
                System.out.println(name + " acquiring success lock on " + lockerB);
                work();
            }
            System.out.println(name + " released lock on " + lockerB);
        }
        System.out.println(name + " released lock on " + lockerA);
        System.out.println(name + " finished execution");
    }

    private void work() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
