package hz.map.multi;

import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;

public class PreFixPut extends MultiMapBench {

    public String prefix = "A";

    public void timeStep() throws InterruptedException, ExecutionException {

        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        getMap().put(prefix + key, val);
    }
}