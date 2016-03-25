package interfaces.classprocessor;

import java.util.*;
import static net.mindview.util.Print.*;

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
