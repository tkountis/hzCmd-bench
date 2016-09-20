package hz.cache;

import hz.cache.base.CacheBench;

public class PutRemove extends CacheBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        cache.put(key, val);
        cache.remove(key);
    }
}