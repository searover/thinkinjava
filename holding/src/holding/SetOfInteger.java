package holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by searover on 3/26/16.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < 7; i ++){
            int j = rand.nextInt(30);
            System.out.print(j + " ");
            intset.add(j);
        }
        System.out.println();
        System.out.println(intset);
    }
}
