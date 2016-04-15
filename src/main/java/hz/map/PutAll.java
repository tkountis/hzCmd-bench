package hz.map;

import hz.map.base.MapBench;
import java.util.*;

public class PutAll extends MapBench {

    public int batchSize=100;
    private Map putAllMap = new HashMap();

    public void timeStep() {
        putAllMap.clear();
        for(int i=0; i<batchSize; i++) {
            int k = random.nextInt(keyDomain);
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            putAllMap.put(k, v);
        }
        map.putAll(putAllMap);
    }
}