package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by searover on 3/27/16.
 */
public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingException2");
    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException("HEllo world");
        }catch (NullPointerException e){
            System.out.println("getCause: " + e.getCause());
            System.out.println("getMessage: " + e.getMessage());
            System.out.println("getLocalizedMessage: " + e.getLocalizedMessage());
            System.out.println("getStackTrace: " + e.getStackTrace());
            System.out.println("getSuppressed: " + e.getSuppressed());
            System.out.println("getClass: " + e.getClass());
            logException(e);
        }
    }
}
