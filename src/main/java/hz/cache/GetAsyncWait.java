package hz.cache;

import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.CacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWait extends CacheBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException, TimeoutException {
        int k = random.nextInt(keyDomain);
        ICompletableFuture f = cache.getAsync(k);
        f.get(timeout, TimeUnit.MILLISECONDS);
    }
}