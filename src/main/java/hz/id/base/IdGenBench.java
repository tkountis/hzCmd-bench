package hz.id.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.Random;

public abstract class IdGenBench extends BasicBenchBase {

    public String name="id";
    public int count=1;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();
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
}