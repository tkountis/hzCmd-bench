package hz.map;

import hz.map.base.MapBench;

import java.util.HashMap;
import java.util.Map;

public class PutAll extends MapBench {

    public int batchSize=100;
    private Map putAllMap = new HashMap();

    public void timeStep() {
        putAllMap.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            Object v = mapKeyToValue(k);
            putAllMap.put(k, v);
        }
        map.putAll(putAllMap);
    }

    public void cleanup() {
        super.cleanup();
        putAllMap.clear();
    }
}