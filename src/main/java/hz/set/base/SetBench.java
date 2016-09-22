package hz.set.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;


public abstract class SetBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected ISet set;

    public void init() throws Exception{
        super.init();
        set = hzInstance.getSet(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " SetBench{" + "hzInstance=" + hzInstance + ", set=" + set + '}';
    }
}