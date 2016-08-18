package holding;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by searover on 5/30/16.
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        Random random = new Random(0);
        random.nextInt(0);
//        FixedCapacityStackOfStrings s;
//        s = new FixedCapacityStackOfStrings(100);
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输出");
//        while (scan.hasNext()) {
//            String item = scan.next();
//            if (!item.equals("-"))
//                s.push(item);
//            else if (!s.isEmpty()) System.out.println(s.pop() + " ");
//        }
//        System.out.println("结束");
//        scan.close();
//        System.out.println("(" + s.size() + " left on stack)");
    }
}
