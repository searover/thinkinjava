import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.junit.Before;
import org.junit.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Created by searover on 4/25/16.
 */
public class KafkaProducerTest {

    private Properties properties;
    private ProducerConfig config;
    private Producer<String, String> producer;

    @Before
    public void setUp() {
        properties = new Properties();
        properties.put("metadata.broker.list", "192.168.103.245:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("partitioner.class", "RoundRobinPartitioner");
        properties.put("request.required.acks", "1");
        config = new ProducerConfig(properties);
        producer = new Producer<String, String>(config);
    }

    @Test
    public void producingTest() throws InterruptedException {
        Random rand = new Random();
        for (int i = 0; i < 200000; i++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rand.nextInt(255);
            String msg = runtime + ",www.51idc.com," + ip;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("chenyl", ip, msg);
            System.out.println("=========================");
            producer.send(data);
            System.out.println(data.key() + "\t" + data.message());
            System.out.println("=========================");
        }
    }

    @Test
    public void testHashmap(){
        Map map = new HashMap();
        map.put("1","2");
    }
}
