package hz.list.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;

public abstract class ListBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected IList list;

    public void init() throws Exception{
        super.init();
        list = hzInstance.getList(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " ListBench{" + "hzInstance=" + hzInstance + ", list=" + list + '}';
    }
}