package hz.atomic.base;


import remote.bench.Bench;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

import java.util.Random;


public abstract class AtomicBench implements Bench {

    public String name;
    protected HazelcastInstance hzInstance;
    protected IAtomicLong atomicLong;
    protected Random random = new Random();

    public void init() {
        atomicLong = hzInstance.getAtomicLong(name);
    }

    public void cleanup() {
        System.out.println("atomicLong "+atomicLong.getName()+" val="+atomicLong.get());
        atomicLong.destroy();
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