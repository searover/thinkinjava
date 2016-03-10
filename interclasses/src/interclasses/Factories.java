package interclasses;

import static net.mindview.util.Print.*;

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {
    }

    @Override
    public void method1() {
        print("Implementation1 method1");
    }

    @Override
    public void method2() {
        print("Implementation2 method2");
    }

    public static ServiceFactory serviceFactory() {
        return () -> new Implementation1();
    }
}

class Implementation2 implements Service {
    private Implementation2() {
    }

    @Override
    public void method1() {
        print("Implementation2 method1");
    }

    @Override
    public void method2() {
        print("Implementation2 method2");
    }

    public static ServiceFactory serviceFactory() {
        return new ServiceFactory() {
            @Override
            public Service getService() {
                return new Implementation2();
            }
        };
    }
}

/**
 * Created by searover on 3/9/16.
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.serviceFactory());
        serviceConsumer(Implementation2.serviceFactory());
    }
}
