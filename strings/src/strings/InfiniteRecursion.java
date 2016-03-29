package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by searover on 3/28/16.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return " InfinitedRecursion address: " + this + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
