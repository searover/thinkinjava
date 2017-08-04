package test_1;

import org.hibernate.sql.JoinType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by searover on 14/07/2017.
 */
public class HelloJob implements Job{

    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Hello World! - " + new Date());
        JoinType joinType;
    }
}
