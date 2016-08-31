package hz.atomic.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

import java.util.Random;


public abstract class AtomicValidate extends BasicBenchBase {

    public String name="AtomicCheck";
    protected IAtomicLong atomic;
    protected IAtomicLong totalInc;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
        atomic = hzInstance.getAtomicLong(name);
        totalInc = hzInstance.getAtomicLong(name+"-totalInc");
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

}