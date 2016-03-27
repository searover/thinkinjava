package exceptions;

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * Created by searover on 3/27/16.
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            print("Caught Exception");
            print("getMessage(): " + e.getMessage());
            print("getLocalizedMessage(): " + e.getLocalizedMessage());
            print("toString(): " + e);
            print("printStackTrace(): ");
            e.printStackTrace(System.out);
            print("getStackTrace(): " + e.getStackTrace());
            print("getStackTrace(): " + Arrays.asList(e.getStackTrace()));
        }
    }
}
