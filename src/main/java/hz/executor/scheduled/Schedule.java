package hz.executor.scheduled;

import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import hz.executor.scheduled.base.ExecutorBench;
import hz.executor.tasks.Counter;

import java.util.concurrent.TimeUnit;

public class Schedule extends ExecutorBench {

    public int scheduleCount=1;
    public int delaySec=0;

    private Counter counter = new Counter();

    public void timeStep() {
        for (int i = 0; i < executorCount; i++) {
            IScheduledExecutorService executor = getExecutor(i);

            for (int j=0; j<scheduleCount; j++) {
                executor.schedule(counter, delaySec, TimeUnit.SECONDS);
            }
        }
        setRunning(false);
    }
}
