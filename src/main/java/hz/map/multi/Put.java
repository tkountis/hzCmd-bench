package hz.map.multi;

import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;

public class Put extends MultiMapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {

        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        getMap().put(key, val);
    }
}