package polymorphism.music;

import static net.mindview.util.Print.*;

class Stringed extends Instrument{
    @Override
    public void play(Note n) {
        print("Stringed.play() " + n);
    }
}

class Brass extends Instrument{
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }
}

/**
 * Created by searover on 3/6/16.
 * Overloading instead of upcasting
 */
public class Music2 {
    public static void tune(Wind i){
        i.play(Note.MIDDLE_C);
    }
    public static void tune(Stringed i){
        i.play(Note.MIDDLE_C);
    }
    public static void tune(Brass i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}
