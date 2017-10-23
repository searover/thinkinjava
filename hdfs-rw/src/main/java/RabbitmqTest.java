import com.rabbitmq.client.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RabbitmqTest {
    public static void main(String[] args) throws ParseException {
//        ConnectionFactory factory = new ConnectionFactory();
        String dateStr = "2017-08-09 14:51:44";
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date date = dateFormat.parse(dateStr);
        HashMap map = new HashMap();
        map.put("d",date);
        System.out.println(map.containsKey("d"));
        System.out.println(map.get("d"));
        System.out.println(map.get("d") instanceof Date);
    }
}
