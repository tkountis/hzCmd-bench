package hz.atomic.base;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import remote.bench.Bench;

import java.util.Random;


public abstract class AtomicMultiBench implements Bench {

    public String name;
    public int    atomicCount=100000;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        for(int i=0; i<atomicCount; i++){
          hzInstance.getAtomicLong(i+name);
        }
    }

    public void cleanup() {
        for(int i=0; i<atomicCount; i++){
            hzInstance.getAtomicLong(i+name).destroy();
        }
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