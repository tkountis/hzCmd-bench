package hz.map.str.base;

import base.StrKeyAllocation;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public abstract class StrMapBench extends StrKeyAllocation {

    protected HazelcastInstance hzInstance;
    protected IMap map;

    public void init() throws Exception{
        super.init();
        map = hzInstance.getMap(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " MapBench{" + "hzInstance=" + hzInstance + ", map=" + map + '}';
    }
}