package hz.lock.base;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;
import remote.bench.Bench;

import java.util.Random;


public abstract class LockBench implements Bench {

    public String name;
    protected HazelcastInstance hzInstance;
    protected ILock lock;
    protected Random random = new Random();

    public void init() {
        lock = hzInstance.getLock(name);
    }

    public void cleanup() {
        System.out.println("lock "+lock.getName()+" isLocked="+lock.isLocked() + " lockCount="+lock.getLockCount());
        lock.destroy();
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
}