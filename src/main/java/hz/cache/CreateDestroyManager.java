package hz.cache;

import com.hazelcast.cache.ICache;
import hz.cache.base.CacheBench;

public class CreateDestroyManager extends CacheBench {
    public void timeStep() {
        cache = (ICache) cacheManager.getCache(""+random.nextInt());
        cacheManager.destroyCache(cache.getName());
    }
}
