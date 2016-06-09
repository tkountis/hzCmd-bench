package hz.cache;

import com.hazelcast.cache.ICache;
import hz.cache.base.CacheBench;

public class CreateDestroy extends CacheBench {
    public void timeStep() {
        cache = (ICache) cacheManager.getCache(""+random.nextInt());
        cache.destroy();
    }
}
