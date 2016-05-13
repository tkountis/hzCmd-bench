package hz.cache;

import com.hazelcast.cache.ICache;
import hz.cache.base.CacheBench;
import hz.lock.base.LockBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends CacheBench {
    public void timeStep() {
        cache = (ICache) cacheManager.getCache("c"+random.nextInt());
        cache.destroy();
    }
}
