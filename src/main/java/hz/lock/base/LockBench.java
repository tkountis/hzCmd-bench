package hz.lock.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;

import java.util.Random;

public abstract class LockBench extends BasicBenchBase {

    public String name="lock";
    public int count=1;

    private ILock[] locks;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        locks = new  ILock[count];
        for(int i=0; i<count; i++) {
            locks[i] = hzInstance.getLock(name+i);
        }
    }

    protected ILock getLock(){
        return locks[random.nextInt(count)];
    }

    protected ILock getLock(int i){
        return locks[i];
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