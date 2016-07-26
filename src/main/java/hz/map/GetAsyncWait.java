package hz.map;

import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWait extends MapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException, TimeoutException {
        int k = random.nextInt(keyDomain);
        ICompletableFuture f = map.getAsync(k);
        f.get(timeout, TimeUnit.MILLISECONDS);
    }
}