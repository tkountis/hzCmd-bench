package hz.lock.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;
import remote.bench.Bench;

import java.util.List;
import java.util.Random;

public abstract class LockCheckBench implements Bench {

    public String name="lockCheck";
    protected ILock lock;
    protected IMap<String, Integer> lockedMap;
    protected IAtomicLong totalInc;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        lock = hzInstance.getLock(name);
        lockedMap = hzInstance.getMap(name);
        lockedMap.put(name, 0);
        totalInc = hzInstance.getAtomicLong(name+"-totalInc");
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }


    public List<Class> ignore(){
        return null;
    }
}