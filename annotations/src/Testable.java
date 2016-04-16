import net.mindview.util.Test;

/**
 * Created by searover on 4/16/16.
 */
public class Testable {
    public void execute(){
        System.out.println("Executing");
    }

    @Test
    void testExecute(){
        execute();
    }
}
