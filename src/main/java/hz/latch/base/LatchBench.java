package hz.latch.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;

import java.util.Random;

public abstract class LatchBench extends BasicBenchBase {

    public String name="latch";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
        for(int i=0; i<count; i++){
            ICountDownLatch latch = hzInstance.getCountDownLatch(name+i);
            latch.trySetCount(Integer.MAX_VALUE);
        }
    }

    protected ICountDownLatch getLatch(){
        return hzInstance.getCountDownLatch(name + random.nextInt(count));
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}