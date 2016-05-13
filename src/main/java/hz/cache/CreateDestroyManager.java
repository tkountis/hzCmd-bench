package hz.cache;

import com.hazelcast.cache.ICache;
import hz.cache.base.CacheBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroyManager extends CacheBench {
    public void timeStep() {
        cache = (ICache) cacheManager.getCache(""+random.nextInt());
        cacheManager.destroyCache(cache.getName());
    }
}
