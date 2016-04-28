import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by searover on 4/27/16.
 */
public class RoundRobinPartitioner implements Partitioner{
    private static AtomicInteger i = new AtomicInteger(0);

    public RoundRobinPartitioner(VerifiableProperties properties) {
    }

    @Override
    public int partition(Object key, int numPartitions) {
        int j = i.incrementAndGet() % numPartitions;
        i.set(j);
        return j;
    }
}
