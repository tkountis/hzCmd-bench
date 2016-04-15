package hz.map.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;


public abstract class MapBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected IMap map;

    public void init() {
        super.init();
        map = hzInstance.getMap(name);
    }

    public void cleanup() {
        map.clear();
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}