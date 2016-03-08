package interfaces.filters;

/**
 * Created by searover on 3/6/16.
 */
public class HighPass extends Filter{
    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
