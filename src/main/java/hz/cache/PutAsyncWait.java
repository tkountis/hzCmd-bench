package hz.cache;

import com.hazelcast.core.HazelcastOverloadException;
import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.CacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsyncWait extends CacheBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {

        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        try {
            ICompletableFuture f = cache.putAsync(key, val);
            try {
                f.get(timeout, TimeUnit.MILLISECONDS);
            } catch (TimeoutException t) {
            }
        }catch (HazelcastOverloadException e){}
    }
}