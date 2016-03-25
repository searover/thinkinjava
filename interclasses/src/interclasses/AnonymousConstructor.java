package interclasses;

import static net.mindview.util.Print.*;

abstract class Base{
    public Base(int i){
        print("Base constructor. i = " + i);
    }
    public abstract void f();
}

/**
 * Created by searover on 3/9/16.
 * Creating a constructor for an anonymous inner class:
 */
public class AnonymousConstructor {

    public static Base getBase(int i){
        return new Base(i) {
            {
                print("Inside instance initializer");
            }
            @Override
            public void f() {
                print("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
        Base base1 = getBase(9);
    }
}
