package exceptions;

/**
 * Created by searover on 3/28/16.
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("exceptions/src/exceptions/Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null){
                    System.out.println(s);
                    // Perform line-by-line processing here...
                }
            }catch (Exception e){
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
