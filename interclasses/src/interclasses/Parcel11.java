package interclasses;

/**
 * Created by searover on 3/9/16.
 * Nested classes (static inner classes).
 */
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    protected static class ParcelDestination implements Destination, Contents{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }
        // Nested classes can contain other static elements.
        public static void f(){}
        static int x = 0;

        @Override
        public int value() {
            return 0;
        }

        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }
    public class Hello{
        private Hello(){}
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }
    public void h(){Hello hello = new Hello();}

    public static void main(String[] args) {

    }
}
