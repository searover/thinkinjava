package interfaces.filters;

/**
 * Created by searover on 3/6/16.
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
