package coherence.base;

import base.BenchBase;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;


public abstract class CacheBench extends BenchBase {

    public NamedCache cache;

    public void setVendorObject(Object vendorObject) { }

    public void init() throws Exception{
        super.init();

        //CacheFactory.ensureCluster();
        cache = CacheFactory.getCache(name);
    }

}