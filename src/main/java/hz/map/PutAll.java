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

            Object key = getKey(k);
            Object val = mapKeyToValue(k);
            putAllMap.put(key, val);
        }
        map.putAll(putAllMap);
    }
}