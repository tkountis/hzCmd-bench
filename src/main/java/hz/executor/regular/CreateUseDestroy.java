package hz.executor.regular;


import com.hazelcast.core.IExecutorService;
import com.hazelcast.core.Member;
import hz.executor.regular.base.ExecutorBench;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CreateUseDestroy extends ExecutorBench{

    public int max=10;

    private Counter counter = new Counter();

    public void timeStep() {
        IExecutorService executor = hzInstance.getExecutorService(name+random.nextInt(max));
        Map<Member, Future<Integer>> map = executor.submitToAllMembers(counter);

        for (Future<Integer> future : map.values()) {
            try {
                Integer i = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.destroy();
    }
}
