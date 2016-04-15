package sample;

/**
 * Created by searover on 4/16/16.
 */
public class Client {
    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
//        TheGreatestSage bird = new Bird(sage);
//        TheGreatestSage fish = new Fish(sage);
//        fish.move();
        sage.move();
        sage = new Bird(sage);
        sage.move();
        sage = new Fish(sage);
        sage.move();
    }
}
