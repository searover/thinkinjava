package polymorphism.music;

/**
 * Created by searover on 3/6/16.
 */
public class Music {

    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
