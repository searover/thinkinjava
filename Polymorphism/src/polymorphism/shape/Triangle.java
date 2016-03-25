package polymorphism.shape;
import static net.mindview.util.Print.*;

/**
 * Created by searover on 3/6/16.
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        print("Triangle.draw()");
    }

    @Override
    public void erase() {
        print("Triangle.erase()");
    }
}
