package hz.atomic.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

import java.util.Random;


public abstract class AtomicBench extends BasicBenchBase {

    public String name="A";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
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

}