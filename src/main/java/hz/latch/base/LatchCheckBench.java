package hz.latch.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;

import java.util.Random;

public abstract class LatchCheckBench extends BasicBenchBase {

    public String name="latchCheck";
    public int latchValue=13;
    protected ICountDownLatch latch;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
        latch = hzInstance.getCountDownLatch(name);
        latch.trySetCount(latchValue);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}