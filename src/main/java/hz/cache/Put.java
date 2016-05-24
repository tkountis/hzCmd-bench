package hz.cache;

import hz.cache.base.CacheBench;

public class Put extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        cache.put(k, v);
    }
}