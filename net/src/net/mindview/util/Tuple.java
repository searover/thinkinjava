package net.mindview.util;

/**
 * Created by searover on 4/1/16.
 */
public class Tuple {
    public static <A,B> TwoTuple tuple(A a, B b){
        return new TwoTuple(a,b);
    }

    public static <A,B,C> ThreeTuple tuple(A a, B b, C c){
        return new ThreeTuple(a,b,c);
    }
}
