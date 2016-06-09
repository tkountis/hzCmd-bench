package hz.cache;

import hz.cache.base.CacheBench;

import java.util.HashMap;
import java.util.Map;

public class PutAll extends CacheBench {

    public int batchSize=100;
    private Map putAllMap = new HashMap();

    public void timeStep() {
        putAllMap.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            Object v = mapKeyToValue(k);
            putAllMap.put(k, v);
        }
        cache.putAll(putAllMap);
    }

    public void cleanup() {
        super.cleanup();
        putAllMap.clear();
    }
}