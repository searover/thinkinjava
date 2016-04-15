package generics;

import net.mindview.util.TwoTuple;
import org.omg.CORBA._IDLTypeStub;

import java.util.ArrayList;

import static net.mindview.util.Tuple.tuple;

/**
 * Created by searover on 4/1/16.
 */
public class TupleTest2 {
    static TwoTuple f() {
//        return new TwoTuple<>("hi", 47);
        return tuple("hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple tutsi = f();
        System.out.println(tutsi);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        System.out.println(a);
    }
}
