package gem.cache;

import gem.cache.base.RegionBench;

public class Put extends RegionBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);

        region.put(key, val);
    }
}