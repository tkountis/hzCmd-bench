package hz.cache.multi;

import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.MultiCacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWait extends MultiCacheBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        ICompletableFuture f = getCache().getAsync(randomKey());
        try {
            f.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException t) { }
    }
}