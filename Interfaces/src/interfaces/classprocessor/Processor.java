package interfaces.classprocessor;

/**
 * Created by searover on 3/6/16.
 */
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}
