package hz.cache.base;

import base.BenchBase;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.HazelcastInstance;

import javax.cache.CacheManager;

import static hz.utils.Utils.getCacheManager;

public abstract class MultiCacheBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected CacheManager cacheManager;

    public int count=10;
    private ICache[] caches;

    public void init() throws Exception {
        super.init();
        cacheManager = getCacheManager(hzInstance);

        caches = new ICache[count];

        for (int i = 0; i < count; i++) {
            caches[i] = (ICache) cacheManager.getCache(name+i);
        }
    }

    public ICache getCache(){
        return caches[random.nextInt(count)];
    }

    public ICache[] getCaches(){
        return caches;
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}