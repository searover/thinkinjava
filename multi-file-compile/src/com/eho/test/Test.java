package com.eho.test;

import com.eho.util.*;

public class Test {

    public static void main(String[] args) {
        // test
        int a = 4, b = 2;
        int sum = CMath.add(a, b);
        System.out.println("a + b = " + sum);
        int div = CMath.div(a, b);
        System.out.println("a / b = " + div);

        // print now
        System.out.println(CTime.strDateTime());
    }
}
