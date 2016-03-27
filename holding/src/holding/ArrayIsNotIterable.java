package holding;

import java.util.Arrays;

/**
 * Created by searover on 3/27/16.
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        // An array works in foreach, but it's not Iterable:
        //! test(strings);
        // You must explicity convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
