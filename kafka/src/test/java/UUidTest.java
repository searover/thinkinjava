import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * Created by searover on 5/23/16.
 */
public class UUidTest {
    @Test
    public void generateUUidTest(){
        System.out.println(UUID.randomUUID().toString());
        Random random = new Random(47);
        for (int i=0;i<50;i++){
            System.out.println(random.nextInt(1));
        }
    }
}
