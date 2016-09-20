package hz.map;

import hz.map.base.MapBench;

public class Set extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.set(key, val);
    }
}