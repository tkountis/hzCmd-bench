package hz.cache;

import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.CacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsyncWait extends CacheBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        ICompletableFuture f = cache.putAsync(k, v);
        try{
            f.get(timeout, TimeUnit.MILLISECONDS);
        }catch (TimeoutException t){}
    }
}