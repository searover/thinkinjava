package interclasses;

/**
 * Created by searover on 3/8/16.
 */
public class DotNew {
    public class Inner{
        public void sayHello(){
            System.out.println("DotNew.Inner.sayHello()");
        }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
        dni.sayHello();
    }
}
