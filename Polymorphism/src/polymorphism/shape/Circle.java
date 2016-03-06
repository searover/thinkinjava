package polymorphism.shape;
import static net.mindview.util.Print.*;

/**
 * Created by searover on 3/6/16.
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }
}
