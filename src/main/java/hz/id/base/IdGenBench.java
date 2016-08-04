package hz.id.base;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import remote.bench.Bench;

import java.util.List;
import java.util.Random;

public abstract class IdGenBench implements Bench {

    public String name="id";
    public int count=1;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() {
        for(int i=0; i<count; i++){
            hzInstance.getIdGenerator(name+i);
        }
    }

    protected IdGenerator getIdObj(){
        return hzInstance.getIdGenerator(name + random.nextInt(count));
    }

    public void cleanup() {
        for(int i=0; i<count; i++){
            hzInstance.getIdGenerator(name + i).destroy();
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


    public List<Class> ignore(){
        return null;
    }
}