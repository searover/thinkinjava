package exceptions;

class VeryImportantException extends Exception{
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception{
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

/**
 * Created by searover on 3/28/16.
 */
public class LostMessage {
    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException{
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            }finally {
                lm.dispose();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
