package generics;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * Created by searover on 4/1/16.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator gco = new BasicGenerator(CountedObject.class);
        System.out.println(gco.next());
        System.out.println(gco.next());
        System.out.println(gco.next());
        System.out.println(gco.next());
        System.out.println(gco.next());
        System.out.println(gco.next());
    }
}
