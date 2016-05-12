package hz.latch.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICountDownLatch;
import remote.bench.Bench;

import java.util.Random;

public abstract class LatchBench implements Bench {

    public String name;
    protected HazelcastInstance hzInstance;
    protected ICountDownLatch latch;
    protected Random random = new Random();

    public void init() {
        latch = hzInstance.getCountDownLatch(name);
        latch.trySetCount(Integer.MAX_VALUE);
    }

    public void cleanup() {
        System.out.println("lock "+latch.getName()+" count="+latch.getCount());
        latch.destroy();
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