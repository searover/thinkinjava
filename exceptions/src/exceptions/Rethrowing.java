package exceptions;

/**
 * Created by searover on 3/27/16.
 */
public class Rethrowing {
    public static void f() throws Exception{
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception{
        try {
            f();
        }catch (Exception e){
            System.out.println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception{
        try {
            f();
        }catch (Exception e){
            System.out.println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
