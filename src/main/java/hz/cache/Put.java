package hz.cache;

import hz.cache.base.CacheBench;

public class Put extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        cache.put(k, v);
    }
}