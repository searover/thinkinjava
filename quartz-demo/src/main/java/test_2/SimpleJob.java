package test_2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by searover on 15/07/2017.
 */
public class SimpleJob implements Job {
    private static Logger logger = LoggerFactory.getLogger(SimpleJob.class);

    public void execute(JobExecutionContext context){
        JobKey jobKey = context.getJobDetail().getKey();
        logger.info("SimpleJob says: " + jobKey + " executing at " + new Date());
    }
}
