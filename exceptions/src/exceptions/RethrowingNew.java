package exceptions;

class OneException extends Exception{
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception{
    public TwoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TwoException(String message) {
        super(message);
    }
}

/**
 * Created by searover on 3/27/16.
 */
public class RethrowingNew {
    public static void f() throws OneException{
        System.out.println("originating the exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("from inner try",e);
            }
        }catch (TwoException e){
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
