public class TraditionalThreadSynchonized {
    public static void main(String[] args) {
        Outputer outputer = new Outputer();
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output("anchnet");
            }
        }).start();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Outputer().output("51idc");
            }
        }).start();
    }
    static class Outputer{
        public void output(String name){
            String a = "1";
            String b = a + "1";
            synchronized (this) {
                for (char c : name.toCharArray()) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}
