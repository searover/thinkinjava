package typeinfo.toys;

import static net.mindview.util.Print.print;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy(){super(1);}
}

/**
 * Created by searover on 3/28/16.
 */
public class ToyTest {
    static void printInfo(Class c){
        print("Class name: " + c.getName() + " is interface? [" + c.isInterface() + "]");
        print("Simple name: " + c.getSimpleName());
        print("Canonical name: " + c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
