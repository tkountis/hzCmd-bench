package hz.atomic.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

import java.util.Random;


public abstract class AtomicBench extends BasicBenchBase {

    public String name="atomic";
    public int count=1;

    private IAtomicLong[] atomicLongs;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        atomicLongs = new IAtomicLong[count];
        for(int i=0; i< count; i++){

            atomicLongs[i]=hzInstance.getAtomicLong(name+i);
        }
    }

    protected IAtomicLong getAtomic(){
        return atomicLongs[random.nextInt(count)];
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public Object getKey(int i){
        return null;
    }

    public Object randomKey(){
        return null;
    }

    public Object mapKeyToValue(int key){
        return null;
    }
}