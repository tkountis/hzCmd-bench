package hz.lock.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;
import remote.bench.Bench;

import java.util.Random;

public abstract class LockBench implements Bench {

    public String name="lock";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        for(int i=0; i<count; i++) {
            hzInstance.getLock(name+i);
        }
    }

    protected ILock getLock(){
        return hzInstance.getLock(name+random.nextInt(count));
    }

    public void cleanup() {
        for(int i=0; i<count; i++) {
            hzInstance.getLock(name+i).destroy();
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