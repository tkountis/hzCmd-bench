package hz.lock.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;

import java.util.Random;

public abstract class LockBench extends BasicBenchBase {

    public String name="lock";
    public int count=1;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
        for(int i=0; i<count; i++) {
            hzInstance.getLock(name+i);
        }
    }

    protected ILock getLock(){
        return hzInstance.getLock(name+random.nextInt(count));
    }

    protected ILock getLock(int i){
        return hzInstance.getLock(name+i);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}