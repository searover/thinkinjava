import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by searover on 6/17/16.
 */
public class JacksonTest {
    @Test
    public void writeAsStringTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,List<String>> extraData = new HashMap<String, List<String>>();
        List<String> eipList = new ArrayList<String>();
        eipList.add("192.168.201.101");
        extraData.put("eips",eipList);
        System.out.println(objectMapper.writeValueAsString(eipList));
        System.out.println(objectMapper.writeValueAsString(extraData));
    }
}
