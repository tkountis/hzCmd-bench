package gem.cache.base;

import base.BenchBase;
import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.Region;


public abstract class RegionBench extends BenchBase {

    protected GemFireCache gemFireCache;
    protected Region region;

    public void setVendorObject(Object vendorObject) {
        gemFireCache = (GemFireCache) vendorObject;
    }

    public void init() throws Exception{
        super.init();
        region = gemFireCache.getRegion(name);
    }

    public void cleanup() {
        region.clear();
    }
}