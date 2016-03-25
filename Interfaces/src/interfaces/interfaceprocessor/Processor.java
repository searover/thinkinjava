package interfaces.interfaceprocessor;

/**
 * Created by searover on 3/6/16.
 */
public interface Processor {
    String name();
    Object process(Object input);
}
