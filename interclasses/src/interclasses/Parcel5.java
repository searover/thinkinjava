package interclasses;

/**
 * Created by searover on 3/8/16.
 * Nesting a class with a method
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label = s;
            private PDestination(String whereTo){
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
