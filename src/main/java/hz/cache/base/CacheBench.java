package hz.cache.base;

import base.BenchBase;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.HazelcastInstance;

import javax.cache.CacheManager;

import static hz.utils.Utils.getCacheManager;

public abstract class CacheBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected CacheManager cacheManager;
    protected ICache cache;

    public void init() throws Exception {
        super.init();
        cacheManager = getCacheManager(hzInstance);
        cache = (ICache) cacheManager.getCache(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}