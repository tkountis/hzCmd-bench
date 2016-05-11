package gg.cache.base;

import base.BenchBase;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;

public abstract class CacheBench extends BenchBase {

    protected Ignite ignite;
    protected IgniteCache<Object, Object> cache;

    public void setVendorObject(Object vendorObject) { ignite = (Ignite) vendorObject; }

    public void init() {
        super.init();
        cache = ignite.getOrCreateCache(name);
    }

    public void cleanup() {
        System.out.println("cache "+cache.getName()+" size="+cache.size());
        cache.clear();
    }
}