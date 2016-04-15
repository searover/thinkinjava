package generics;

/**
 * Created by searover on 4/1/16.
 */
public class GenericMethods {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
        GenericClass gc = new GenericClass();
        gm.f(gc);
        GenericClass<IterableFibonacci> gc2 = new GenericClass<>();
        gm.f(gc2);
    }
}
