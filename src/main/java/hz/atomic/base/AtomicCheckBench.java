package hz.atomic.base;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import remote.bench.Bench;

import java.util.List;
import java.util.Random;


public abstract class AtomicCheckBench implements Bench {

    public String name="AtomicCheck";
    protected IAtomicLong atomic;
    protected IAtomicLong totalInc;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        atomic = hzInstance.getAtomicLong(name);
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