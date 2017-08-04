package test_2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by searover on 15/07/2017.
 */
public class SimpleTriggerExample {
    public void run() throws SchedulerException {
        Logger logger = LoggerFactory.getLogger(SimpleTriggerExample.class);

        logger.info("----- Initializing -----");
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        logger.info("----- Initialization complete -----");

        logger.info("----- Scheduling jobs -----");

        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

        // Job will only fire once at date/time "ts"
        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger1", "group1").startAt(startTime).build();

        // Schedule it to run
        Date ft = scheduler.scheduleJob(job, trigger);

        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Job2 will only fire once at date/time "ts"
        job = newJob(SimpleJob.class).withIdentity("job2", "group1").build();

        trigger = (SimpleTrigger) newTrigger().withIdentity("trigger2", "group1").startAt(startTime).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Job3 will run 11 times (run once and repeat 10 more times)
        // Job3 will repeat every 10 seconds
        job = newJob(SimpleJob.class).withIdentity("job3", "group1").build();
        trigger = newTrigger().withIdentity("trigger3", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // The same job(job3) will be scheduled by another trigger
        // This time will only repeat twice at a 10 second interval
        trigger = newTrigger().withIdentity("trigger3", "group2").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(2)).forJob(job).build();

        ft = scheduler.scheduleJob(trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Job4 will run 6 times (run once and repeat 5 more times)
        // Job4 will repeat every 10 seconds
        job = newJob(SimpleJob.class).withIdentity("job4", "group1").build();

        trigger = newTrigger().withIdentity("trigger4", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(5)).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Job5 will run once, five minutes in the future
        job = newJob(SimpleJob.class).withIdentity("job5", "group1").build();
        trigger = (SimpleTrigger) newTrigger().withIdentity("trigger5", "group1").startAt(
                futureDate(5, DateBuilder.IntervalUnit.MINUTE)).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Job6 will run indefinitely, every 40 seconds
        job = newJob(SimpleJob.class).withIdentity("job6", "group1").build();

        trigger = newTrigger().withIdentity("trigger6", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");
        logger.info("----- Starting scheduler -----");

        scheduler.start();

        logger.info("----- Started Scheduler -----");

        // Jobs can also be scheduled after start() has been called...
        // Job7 will repeat 20 times, repeat every five minutes
        job = newJob(SimpleJob.class).withIdentity("job7", "group1").build();

        trigger = newTrigger().withIdentity("trigger7", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(20)).build();

        ft = scheduler.scheduleJob(job, trigger);
        logger.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() +
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // Jobs can be fired directly... (rather than waiting for a trigger)
        job = newJob(SimpleJob.class).withIdentity("job8", "group1").storeDurably().build();
        scheduler.addJob(job, true);

        logger.info("'Manually' triggering job8...");
        scheduler.triggerJob(jobKey("job8", "group1"));

        logger.info("----- Waiting for 30 seconds... -----");

        try {
            // wait 33 seconds to show jobs
            Thread.sleep(30L * 1000L);
        } catch (InterruptedException e) {
        }

        // Jobs can be re-scheduled...
        // job7 will run immediately and repeat 10 times for every second
        logger.info("----- Rescheduling... -----");
        trigger = newTrigger().withIdentity("trigger7", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(20)).build();

        ft = scheduler.rescheduleJob(trigger.getKey(), trigger);
        logger.info("job7 rescheduled to run at: " + ft);

        logger.info("----- Waiting five minutes... -----");
        try {
            // wait five minutes to show jobs
            Thread.sleep(300L * 1000L);
        } catch (InterruptedException e) {
        }

        logger.info("----- Shutting down -----");
        scheduler.shutdown(true);
        logger.info("----- Shutdown complete -----");

        // Display some stats about the schedule that just ran
        SchedulerMetaData metaData = scheduler.getMetaData();
        logger.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }

    public static void main(String[] args) throws SchedulerException {
        SimpleTriggerExample example = new SimpleTriggerExample();
        example.run();
    }
}
