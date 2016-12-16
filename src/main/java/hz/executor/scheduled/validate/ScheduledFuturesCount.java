package hz.executor.scheduled.validate;

import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.IScheduledFuture;
import global.AssertionException;
import hz.executor.scheduled.base.ExecutorBench;

import java.util.List;

public class ScheduledFuturesCount extends ExecutorBench {

    public int scheduleCount=1;
    public boolean validateOnce=false;

    public void timeStep() throws AssertionException {

        int totalScheduledFuturesCount=0;
        for (int i = 0; i < executorCount; i++) {
            IScheduledExecutorService executor = getExecutor(i);

            for (List<IScheduledFuture<Object>> scheduledFuturesPerMember : executor.getAllScheduledFutures().values()) {
                totalScheduledFuturesCount += scheduledFuturesPerMember.size();
            }
        }

        int expectedTotal = executorCount * scheduleCount;
        if(totalScheduledFuturesCount != expectedTotal ){
            throw new AssertionException("total Scheduled Futures Count "+totalScheduledFuturesCount+" != "+expectedTotal);
        }

        if(validateOnce==true){
            setRunning(false);
        }
    }
}
