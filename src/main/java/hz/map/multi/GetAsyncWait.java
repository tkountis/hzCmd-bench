package hz.map.multi;

import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWait extends MultiMapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        ICompletableFuture f = getMap().getAsync(randomKey());
        try {
            f.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException t) { }
    }
}