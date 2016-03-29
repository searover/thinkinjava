package exceptions;

class BaseballException extends Exception{}

class Foul extends BaseballException{}

class Strike extends BaseballException{}

abstract class Inning{
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract void atBat() throws Strike, Foul;
    public void walk(){}
}

class StormException extends Exception{}

class RaineOut extends StormException{}

class PopFoul extends Foul{}

interface Storm{
    void event() throws RaineOut;
    void rainHard() throws RaineOut;
}

/**
 * Created by searover on 3/28/16.
 * Overridden methods may throw only the exceptions specified in their base-class versions,
 * or exception derived from the base-class exceptions.
 */
public class StormyInning extends Inning implements Storm{

    // OK to add new exceptions for constructors, but you must deal with the base constructor exceptions:
    public StormyInning() throws BaseballException, RaineOut {
    }

    public StormyInning(String s) throws Foul, BaseballException{

    }

//    @Override
//    public void walk() throws PopFoul {
//        super.walk();
//    }


//    @Override
//    public void event() throws RaineOut {
//        super.event();
//    }

    @Override
    public void atBat() throws Strike, Foul {

    }

    // If the method does not already exist in the base class, the exception is OK:
    @Override
    public void rainHard() throws RaineOut {

    }

    // You can choose to not throw any exceptions, even if the base version does:
    @Override
    public void event() {
    }


}
