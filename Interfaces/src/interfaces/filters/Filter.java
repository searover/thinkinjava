package interfaces.filters;

/**
 * Created by searover on 3/6/16.
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}
