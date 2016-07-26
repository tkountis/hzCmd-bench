package hz.map;

import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsyncWait extends MapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException, TimeoutException {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        ICompletableFuture f = map.putAsync(k, v);
        f.get(timeout, TimeUnit.MILLISECONDS);
    }

}