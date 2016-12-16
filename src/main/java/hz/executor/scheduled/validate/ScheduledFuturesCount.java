package hz.executor.scheduled.validate;

import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.IScheduledFuture;
import global.AssertionException;
import hz.executor.scheduled.base.ExecutorBench;
import hz.executor.tasks.Counter;

import java.util.List;

public class ScheduledFuturesCount extends ExecutorBench {

    public int count=0;

    private Counter counter = new Counter();

    public void timeStep() throws AssertionException {

        int totalScheduledFuturesCount=0;
        for (int i = 0; i < executorCount; i++) {
            IScheduledExecutorService executor = getExecutor(i);

            for (List<IScheduledFuture<Object>> scheduledFuturesPerMember : executor.getAllScheduledFutures().values()) {
                totalScheduledFuturesCount += scheduledFuturesPerMember.size();
            }
        }

        if(totalScheduledFuturesCount != count ){
            throw new AssertionException("total Scheduled Futures Count "+totalScheduledFuturesCount+" != "+count);
        }
    }
}
