package hz.map;

import com.hazelcast.core.HazelcastOverloadException;
import com.hazelcast.core.ICompletableFuture;
import hz.map.base.MapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWait extends MapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        int k = random.nextInt(keyDomain);

        try {
            ICompletableFuture f = map.getAsync(k);
            try {
                f.get(timeout, TimeUnit.MILLISECONDS);
            } catch (TimeoutException t) {}
        }catch (HazelcastOverloadException e){}
    }
}