package hz.map.multi;

import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsyncWait extends MultiMapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {

        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        ICompletableFuture f = getMap().putAsync(key, val);
        try {
            f.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException t) {}
    }
}