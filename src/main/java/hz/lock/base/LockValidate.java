package hz.lock.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;

import java.util.Random;

public abstract class LockValidate extends BasicBenchBase {

    public String name="lockCheck";
    protected ILock lock;
    protected IMap<String, Integer> lockedMap;
    protected IAtomicLong totalInc;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
        lock = hzInstance.getLock(name);
        lockedMap = hzInstance.getMap(name);
        lockedMap.put(name, 0);
        totalInc = hzInstance.getAtomicLong(name+"-totalInc");
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}