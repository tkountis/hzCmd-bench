package hz.repmap;

import hz.repmap.base.RepMapBench;

public class Put extends RepMapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.put(key, val);
    }

}