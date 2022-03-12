package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.security.sasl.SaslException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {

    public static void main(String[] args) {

        Connection cn;

        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            data.put("cn", cn);
            JobDetail job = newJob(Rabbit.class)
                    .usingJobData(data)
                    .build();
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(getJobInterval())
                    .repeatForever();
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            scheduler.scheduleJob(job, trigger);
            Thread.sleep(10000);
            scheduler.shutdown();
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    public static int getJobInterval() {
        int rls;
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            Properties jobProperties = new Properties();
            jobProperties.load(in);
            rls = Integer.parseInt(jobProperties.getProperty("rabbit.interval"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return rls;
    }

    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            Connection cn = (Connection) context.getJobDetail().getJobDataMap().get("cn");
            try (PreparedStatement ps =
                         cn.prepareStatement("insert into rabbit (created_date) values (?)")) {
                ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                ps.execute();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
