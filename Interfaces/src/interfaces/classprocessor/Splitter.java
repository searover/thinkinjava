package interfaces.classprocessor;

import java.util.Arrays;

/**
 * Created by searover on 3/6/16.
 */
public class Splitter extends Processor{
    String process(Object input) {
        // The split() argument divides a String into pieces.
        return Arrays.toString(((String)input).split(" "));
    }
}
