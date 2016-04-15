package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by searover on 4/3/16.
 */
public class Unsupported {
    static void test(String msg, List<String> list){
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        System.out.println(list.getClass().getName());
        Collection<String> subList = list.subList(1,8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);
        c.removeAll(c2);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        List<String> l = new ArrayList<>();
        List<String> l2 = Arrays.asList("a");
        System.out.println(l.getClass().getName());
        System.out.println(l2.getClass().getName());
        l.add("a");
        l.remove("a");
//        test("Mofifiable Copy",list);
    }
}
