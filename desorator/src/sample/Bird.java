package sample;

/**
 * Created by searover on 4/16/16.
 */
public class Bird extends Change{
    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Bird move");
    }
}
