package holding;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by searover on 3/12/16.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            c.add(i); // Autoboxing
        }
        for (Integer i : c){
            System.out.println(i + ", ");
        }
    }
}
