package net.mindview.util;

import java.util.IntSummaryStatistics;

/**
 * Created by searover on 4/1/16.
 */
public class BasicGenerator<T> implements Generator<T> {
//    private Class<T> type;
    private T t;

    public BasicGenerator(T t) {
        this.t = t;
    }

//    public BasicGenerator(Class<T> type){
//        this.type = type;
//    }

    @Override
    public T next() {
        // Assumes type is a public class:
        try {
//            return type.newInstance();
            return (T) ((Class)t).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a Default generator given a type token:
    public static <T> Generator create(Class type) {
        return new BasicGenerator(type);
    }

    public static void main(String[] args) {
        Generator gen = create(IntSummaryStatistics.class);
        System.out.println(gen.next());
    }
}
