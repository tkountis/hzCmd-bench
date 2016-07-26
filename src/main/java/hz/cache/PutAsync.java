package hz.cache;

import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.CacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsync extends CacheBench {

    int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException, TimeoutException {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        ICompletableFuture f = cache.putAsync(k, v);
        f.get(timeout, TimeUnit.SECONDS);
    }
}