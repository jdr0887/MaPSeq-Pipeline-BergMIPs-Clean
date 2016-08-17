package edu.unc.mapseq.executor.bergmips.clean;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BergMIPsCleanWorkflowExecutorService {

    private static final Logger logger = LoggerFactory.getLogger(BergMIPsCleanWorkflowExecutorService.class);

    private final Timer mainTimer = new Timer();

    private BergMIPsCleanWorkflowExecutorTask task;

    private Long period = 5L;

    public BergMIPsCleanWorkflowExecutorService() {
        super();
    }

    public void start() throws Exception {
        logger.info("ENTERING start()");
        long delay = 1 * 60 * 1000; // 1 minute
        mainTimer.scheduleAtFixedRate(task, delay, period * 60 * 1000);
    }

    public void stop() throws Exception {
        logger.info("ENTERING stop()");
        mainTimer.purge();
        mainTimer.cancel();
    }

    public BergMIPsCleanWorkflowExecutorTask getTask() {
        return task;
    }

    public void setTask(BergMIPsCleanWorkflowExecutorTask task) {
        this.task = task;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

}
