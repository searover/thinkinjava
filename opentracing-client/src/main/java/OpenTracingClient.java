import com.uber.jaeger.Configuration;
import com.uber.jaeger.metrics.InMemoryStatsReporter;
import com.uber.jaeger.metrics.StatsFactory;
import com.uber.jaeger.metrics.StatsFactoryImpl;
import com.uber.jaeger.metrics.StatsReporter;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

/**
 * Created by searover on 27/06/2017.
 */
public class OpenTracingClient {
    public static void main(String[] args) {
        StatsReporter reporter = new InMemoryStatsReporter();
        StatsFactory factory = new StatsFactoryImpl(reporter);
        Tracer tracer =
                new Configuration("localhost",
                        new Configuration.SamplerConfiguration("const", 1),
                        new Configuration.ReporterConfiguration(
                                false,
                                "localhost",
                                5775, 100, 100000)
                ).getNoopTracer();
        GlobalTracer.register(tracer);
        Span parent = tracer.buildSpan("hello").start();
        try {
            Span child = tracer.buildSpan("world").asChildOf(parent).start();
            System.out.println("do things");
        } finally {
            System.out.println("finally");
            parent.finish();
        }
        System.out.println("done");
        System.exit(0);
//        Span child = GlobalTracer.get().buildSpan("world").asChildOf(parent).startManual();

    }
}
