package interclasses;

class WithInner{
    class Inner{}
}

/**
 * Created by searover on 3/11/16.
 */
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner w = new WithInner();
        InheritInner i = new InheritInner(w);
    }
}
