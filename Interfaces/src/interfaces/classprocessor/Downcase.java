package interfaces.classprocessor;

/**
 * Created by searover on 3/6/16.
 */
class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toLowerCase();
    }
}
