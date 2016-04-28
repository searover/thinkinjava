import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by searover on 4/28/16.
 */
public class KafkaConsumerTest {
    private Properties props;
    private ConsumerConfig consumerConfig;
    private ConsumerConnector connector;
    private ConsumerIterator<byte[], byte[]> iterator;
    private ConsumerIterator<byte[], byte[]> iterator2;

    @Before
    public void setUp(){
        props = new Properties();
        props.put("zookeeper.connect", "192.168.9.21:2181");
        props.put("group.id", "java_tester_1");
        props.put("zookeeper.session.timeout.ms", "150000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.offset.reset", "smallest");
        props.put("auto.commit.enable", "true");

        consumerConfig = new ConsumerConfig(props);
        connector = Consumer.createJavaConsumerConnector(consumerConfig);
    }

    @Test
    public void sigleTopicMultiConsumerInstanceTest() throws InterruptedException {
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put("create_router", 2);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
                connector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("create_router");
        KafkaStream<byte[], byte[]> kafkaStream = streams.get(0);
        KafkaStream<byte[], byte[]> kafkaStream2 = streams.get(1);
        iterator = kafkaStream.iterator();
        iterator2 = kafkaStream2.iterator();
        MessageAndMetadata<byte[], byte[]> mam = iterator.next();
        MessageAndMetadata<byte[], byte[]> mam2 = iterator2.next();
        String message = new String(mam.message());
        String message2 = new String(mam2.message());
        System.out.println(streams.size());
        printMessage(mam, mam2, message, message2);
    }

    @Test
    public void multiTopicSingleConsumerInstanceTest() throws InterruptedException {
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put("create_router", 1);
        topicCountMap.put("delete_router", 1);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
                connector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> createRouterStream = consumerMap.get("create_router");
        List<KafkaStream<byte[], byte[]>> deleteRouterStream = consumerMap.get("delete_router");
        iterator = createRouterStream.get(0).iterator();
        iterator2 = deleteRouterStream.get(0).iterator();
        MessageAndMetadata<byte[], byte[]> mam = iterator.next();
        MessageAndMetadata<byte[], byte[]> mam2 = iterator2.next();
        String message = new String(mam.message());
        String message2 = new String(mam2.message());
        printMessage(mam, mam2, message, message2);
    }

    private void printMessage(MessageAndMetadata<byte[], byte[]> mam, MessageAndMetadata<byte[], byte[]> mam2, String message, String message2) throws InterruptedException {
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println(mam.partition());
        System.out.println(message);
        System.out.println(mam2.partition());
        System.out.println(message2);
        System.out.println("===============================");
        System.out.println("===============================");
        Thread.sleep(5*1000);
        connector.shutdown();
    }
}
