package polymorphism;

import static net.mindview.util.Print.*;

class Glyph{
    void draw(){
        print("Glyph.draw()");
    }

    Glyph(){
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;
    RoundGlyph(int r){
        print("RoundGlyph.RoundGyph(), radius = " + radius);
    }

    @Override
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

/**
 * Created by searover on 3/6/16.
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
