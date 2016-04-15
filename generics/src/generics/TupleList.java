package generics;

import net.mindview.util.ThreeTuple;

import java.util.ArrayList;


/**
 * Created by searover on 4/2/16.
 */
public class TupleList<A,B,C> extends ArrayList<ThreeTuple> {
    public static void main(String[] args) {
        TupleList<Vehicle,Amphibian,String> tl = new TupleList<>();
        tl.add(TupleTest.g());
        tl.add(TupleTest.g());
        for (ThreeTuple tt : tl){
            System.out.println(tt);
        }
    }
}
