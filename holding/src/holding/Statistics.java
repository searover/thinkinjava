package holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by searover on 3/27/16.
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i ++){
            // Produce a number between 0 and 20.
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r,freq == null ? 0 : ++freq);
        }
        System.out.println(m);
    }
}
