package hz.executor.scheduled;

import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.IScheduledFuture;
import hz.executor.scheduled.base.ExecutorBench;
import hz.executor.tasks.Counter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CreateUseDestroy extends ExecutorBench {

    public int delaySec=0;

    private Counter counter = new Counter();

    public void timeStep() {
        IScheduledExecutorService scheduledExecutorService = hzInstance.getScheduledExecutorService(name + random.nextInt(executorCount));
        IScheduledFuture<Integer> future = scheduledExecutorService.schedule(counter, delaySec, TimeUnit.SECONDS);

        try {
            Integer i = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.destroy();
    }
}
