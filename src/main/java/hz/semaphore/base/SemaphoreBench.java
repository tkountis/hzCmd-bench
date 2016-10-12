package hz.semaphore.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISemaphore;

import java.util.Random;

public abstract class SemaphoreBench extends BasicBenchBase {

    public String name="semaphore";
    public int count=1;

    private ISemaphore[] semaphores;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        semaphores = new  ISemaphore[count];
        for(int i=0; i<count; i++) {
            semaphores[i] = hzInstance.getSemaphore(name+i);
        }
    }

    protected ISemaphore getSemaphore(){
        return semaphores[random.nextInt(count)];
    }

    protected ISemaphore getSemaphore(int i){
        return semaphores[i];
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