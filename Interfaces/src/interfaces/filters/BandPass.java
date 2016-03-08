package interfaces.filters;

/**
 * Created by searover on 3/6/16.
 */
public class BandPass extends Filter{
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
