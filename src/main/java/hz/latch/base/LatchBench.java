package hz.latch.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;
import remote.bench.Bench;

import java.util.Random;

public abstract class LatchBench implements Bench {

    public String name="latch";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        for(int i=0; i<count; i++){
            ICountDownLatch latch = hzInstance.getCountDownLatch(name+i);
            latch.trySetCount(Integer.MAX_VALUE);
        }
    }

    protected ICountDownLatch getLatch(){
        return hzInstance.getCountDownLatch(name + random.nextInt(count));
    }

    public void cleanup() {
        for(int i=0; i<count; i++) {
            hzInstance.getCountDownLatch(name+i).destroy();
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