package hz.atomic.base;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import remote.bench.Bench;

import java.util.Random;


public abstract class AtomicBench implements Bench {

    public String name="atomic";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        for(int i=0; i< count; i++){
          hzInstance.getAtomicLong(name+i);
        }
    }

    protected IAtomicLong getAtomic(){
        return hzInstance.getAtomicLong(name+random.nextInt(count));
    }

    public void cleanup() {
        for(int i=0; i< count; i++){
            hzInstance.getAtomicLong(name+i).destroy();
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