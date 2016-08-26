package hz.latch.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;
import remote.bench.Bench;

import java.util.List;
import java.util.Random;

public abstract class LatchCheckBench implements Bench {

    public String name="latchCheck";
    public int latchValue=13;
    protected ICountDownLatch latch;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        latch = hzInstance.getCountDownLatch(name);
        latch.trySetCount(latchValue);
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