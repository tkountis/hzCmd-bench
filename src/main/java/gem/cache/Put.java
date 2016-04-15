package gem.cache;

import gem.cache.base.RegionBench;

public class Put extends RegionBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        region.put(k, v);
    }
}