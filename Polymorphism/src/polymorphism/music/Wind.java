package polymorphism.music;
/**
 * Created by searover on 3/6/16.
 * Wind objects are instruments because they have the same interface
 */
public class Wind extends Instrument{
    // Refine interface method.


    @Override
    public void play(Note n) {
        System.out.print("Wind.play() " + n);
    }
}
