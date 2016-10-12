package hz.executor.durable;

import com.hazelcast.durableexecutor.DurableExecutorService;
import com.hazelcast.durableexecutor.DurableExecutorServiceFuture;
import hz.executor.durable.base.ExecutorBench;
import hz.executor.tasks.Counter;

import java.util.concurrent.ExecutionException;

public class CreateUseDestroy extends ExecutorBench {

    public int max=10;

    private Counter counter = new Counter();

    public void timeStep() {
        DurableExecutorService executor = hzInstance.getDurableExecutorService(name+random.nextInt(max));
        DurableExecutorServiceFuture<Integer> future = executor.submit(counter);

        try {
            Integer i = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.destroy();
    }
}
