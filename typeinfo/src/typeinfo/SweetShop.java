package typeinfo;

import static net.mindview.util.Print.print;

class Candy{
    static {
        print("Loading Candy");
    }
}

class Gum{
    static {
        print("Loading Gum");
    }
}

class Cookie{
    static {
        print("Loading Cookie");
    }
}

/**
 * Created by searover on 3/28/16.
 */
public class SweetShop {
    public static void main(String[] args) {
        print("Inside main");
        new Candy().getClass();
        print("After creating Candy");
        try {
            Class clazz = Class.forName("typeinfo.Gum");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
}
