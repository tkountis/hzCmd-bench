package hz.cache.base;

import base.BenchBase;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.HazelcastInstance;

import javax.cache.CacheManager;

import static hz.utils.Utils.getCacheManager;
import static utils.Utils.dymanicValues;

public abstract class CacheBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected ICache cache;

    public void init() {
        super.init();
        CacheManager cacheManager = getCacheManager(hzInstance);
        cache = (ICache) cacheManager.getCache(name);
    }

    public void cleanup() {
        cache.clear();
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}