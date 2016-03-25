package polymorphism.shape;
import static net.mindview.util.Print.*;

/**
 * Created by searover on 3/6/16.
 */
public class Square extends Shape {
    @Override
    public void draw() {
        print("Square.draw()");
    }

    @Override
    public void erase() {
        print("Square.erase()");
    }
}
