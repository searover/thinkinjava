package holding;

import java.util.Map;

/**
 * Created by searover on 3/27/16.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
