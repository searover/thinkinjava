package generics;

import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

class Amphibian {
}

class Vehicle {
}

/**
 * Created by searover on 3/30/16.
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
    }
}
