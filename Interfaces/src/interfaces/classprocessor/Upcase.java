package interfaces.classprocessor;

/**
 * Created by searover on 3/6/16.
 */
public class Upcase extends Processor{
    // Covariant return
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}
