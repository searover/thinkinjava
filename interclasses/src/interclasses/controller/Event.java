package interclasses.controller;

/**
 * Created by searover on 3/11/16.
 * The common methods for any control event.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }

    protected void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
