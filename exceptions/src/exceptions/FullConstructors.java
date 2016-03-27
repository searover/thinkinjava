package exceptions;

class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

/**
 * Created by searover on 3/27/16.
 */
public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public static void  g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
