package interfaces.filters;

/**
 * Created by searover on 3/6/16.
 */
public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input; // Dummy processing
    }
}
