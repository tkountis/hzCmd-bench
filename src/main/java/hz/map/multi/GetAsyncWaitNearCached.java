package hz.map.multi;

import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.core.IMap;
import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetAsyncWaitNearCached extends MultiMapBench {

    public int timeout=0;
    public double repeat=0.3;

    IMap map;
    Object key;

    public void init() throws Exception {
        super.init();

        map = getMap();
        key = randomKey();
    }


    public void timeStep() throws InterruptedException, ExecutionException {

        if( random.nextDouble() > repeat ){
            map = getMap();
            key = randomKey();
        }

        ICompletableFuture f = map.getAsync(key);
        try {
            f.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException t) { }
    }

}