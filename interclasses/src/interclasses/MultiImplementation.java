package interclasses;

class D {
}

abstract class E {
}

class Z extends D {
    E makeE() {
        return new E() {

        };
    }
}

/**
 * Created by searover on 3/9/16.
 * With concrete or abstract classes, inner classes are the only way to produce the effect
 * of "multiple implementation inheritance."
 */
public class MultiImplementation {
    static void takesD(D d) {
    }

    static void takesE(E e) {
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

interface A {
   void f();
}
interface B{
    void f();
}
class C implements A,B{

    @Override
    public void f() {

    }
}
