package hz.cache;

import hz.cache.base.CacheBench;

public class PutGet extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        cache.put(key, val);
        cache.get(key);
    }
}