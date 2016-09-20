package hz.latch.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;

import java.util.Random;

public abstract class LatchBench extends BasicBenchBase {

    public String name="latch";
    public int count=1;
    private ICountDownLatch[] latchs;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        latchs = new ICountDownLatch[count];
        for(int i=0; i<count; i++){
            ICountDownLatch latch = hzInstance.getCountDownLatch(name+i);
            latch.trySetCount(Integer.MAX_VALUE);
            latchs[i]=latch;
        }
    }

    protected ICountDownLatch getLatch(){
        return latchs[random.nextInt(count)];
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