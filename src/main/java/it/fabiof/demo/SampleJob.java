package it.fabiof.demo;

import org.quartz.JobExecutionContext;

import it.fabioformosa.quartzmanager.jobs.AbstractLoggingJob;
import it.fabioformosa.quartzmanager.jobs.entities.LogRecord;
import it.fabioformosa.quartzmanager.jobs.entities.LogRecord.LogType;


public class SampleJob extends AbstractLoggingJob {

    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        return new LogRecord(LogType.INFO, "Hello from QuartManagerDemo!");
    }

}
