package hz.cache;

import hz.cache.base.CacheBench;

public class PutGet extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        cache.put(k, v);
        cache.get(k);
    }
}