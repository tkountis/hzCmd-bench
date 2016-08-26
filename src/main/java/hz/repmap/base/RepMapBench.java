package hz.repmap.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ReplicatedMap;


public abstract class RepMapBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected ReplicatedMap map;

    public void init() throws Exception{
        super.init();
        map = hzInstance.getReplicatedMap(name);
    }


    public void cleanup() {
        System.out.println("map "+map.getName()+" size="+map.size());
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}