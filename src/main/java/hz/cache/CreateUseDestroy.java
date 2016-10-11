package hz.cache;

import com.hazelcast.cache.ICache;
import hz.cache.base.CacheBench;

public class CreateUseDestroy extends CacheBench {

    public int max=10;

    public void timeStep() {
        cache = (ICache) cacheManager.getCache(name+random.nextInt(max));

        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        cache.put(key, val);
        cache.get(key);

        cache.destroy();
    }
}
