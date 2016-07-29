package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PutAsyncWait extends MapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);

        try {
            ICompletableFuture f = map.putAsync(k, v);
            try {
                f.get(timeout, TimeUnit.MILLISECONDS);
            } catch (TimeoutException t) {}
        }catch (HazelcastOverloadException e){}
    }
}