package gem.cache.base;

import base.BenchBase;
import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.Region;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;


public abstract class RegionBench extends BenchBase {

    protected GemFireCache gemFireCache;
    protected Region region;

    public void setVendorObject(Object vendorObject) {
        gemFireCache = (GemFireCache) vendorObject;
    }

    public void init() {
        super.init();
        region = gemFireCache.getRegion(name);
    }

    public void cleanup() {
        region.clear();
    }
}