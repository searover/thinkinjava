package interfaces.classprocessor;

import java.util.*;
import static net.mindview.util.Print.*;

class Processor{
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    // Covariant return
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor{
    String process(Object input) {
        // The split() argument divides a String into pieces.
        return Arrays.toString(((String)input).split(" "));
    }
}

/**
 * Created by searover on 3/6/16.
 */
public class Apply {
    public static void process(Processor p, Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }
    public static String s = "Disagreement with belifs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
