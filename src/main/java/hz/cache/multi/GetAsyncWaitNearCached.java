package hz.cache.multi;

import com.hazelcast.cache.ICache;
import com.hazelcast.core.ICompletableFuture;
import hz.cache.base.MultiCacheBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWaitNearCached extends MultiCacheBench {

    public int timeout=0;
    public double repeat=0.3;

    ICache cache;
    Object key;

    public void init() throws Exception {
        super.init();

        cache = getCache();
        key = randomKey();
    }


    public void timeStep() throws InterruptedException, ExecutionException {

        /*
        if( !(random.nextDouble() < repeat) ){
            cache = getCache();
            key = randomKey();
        }
        */

        ICompletableFuture f = cache.getAsync(key);
        try {
            f.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException t) { }
    }

}