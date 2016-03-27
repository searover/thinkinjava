package holding;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by searover on 3/26/16.
 */
public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intset = new TreeSet<>();
        for (int i = 0; i < 10000; i ++){
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
