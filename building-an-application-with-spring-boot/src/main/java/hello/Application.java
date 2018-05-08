package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements ServletContextListener, CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Service started........");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context initialized.............................");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (thread != null && thread.isAlive()) {
//            try {
//                thread.join(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Context destroyed...............................");
    }

    Thread thread;
    int i = 0;

    @Override
    public void run(String... args) throws Exception {
        thread = new Thread(() -> {
            while (true) {
                System.out.println("say hi --> " + this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
        thread.start();
    }

    @Scheduled(cron = "* * * * * * ")
    public void sayHello() {
        System.out.println("Say hello.");
    }
}
