package interfaces.interfaceprocessor;

import static net.mindview.util.Print.*;
/**
 * Created by searover on 3/6/16.
 */
public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
}
