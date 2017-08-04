package test_1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by searover on 07/07/2017.
 */
public class SimpleExample {
    public void run() throws SchedulerException {
        Logger logger = LoggerFactory.getLogger(SimpleExample.class);
        logger.info("----------------- Initializing ------------------");

        // First we must get a reference to a scheduler

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        logger.info("----------------- Initialization complete ------------------");

        // Compute a time that is on the next round minute
        Date runTime = evenMinuteDate(new Date());

        logger.info("----------------- Scheduling job ----------------");

        // Define the job and tie it to our test_1.HelloJob class
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // Trigger the job to run on the nextround minute
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        // Start up the scheduler ( nothing can actually run until the scheduler has been started)
//        scheduler.start();

        logger.info("----------------- Started Scheduler -------------------");

        // Wait long enough so that the scheduler as an opportunity to run the job!
        logger.info("----------------- Waiting 65 seconds... ---------------");
        try {
            Thread.sleep(65L * 1000L);
        } catch (InterruptedException e) {
        }

        // Shutdown the scheduler
        logger.info("----------------- Shutting Down -----------------------");
        scheduler.shutdown(true);
        logger.info("----------------- Shutdown Complete -------------------");
    }

    public static void main(String[] args) throws SchedulerException {
        SimpleExample example = new SimpleExample();
        example.run();
    }
}
