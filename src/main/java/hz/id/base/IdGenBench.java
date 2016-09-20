package hz.id.base;

import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.Random;

public abstract class IdGenBench extends BasicBenchBase {

    public String name="id";
    public int count=1;
    private IdGenerator[] ids;

    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        ids = new IdGenerator[count];
        for(int i=0; i< count; i++){
            ids[i]=hzInstance.getIdGenerator(name+i);
        }
    }

    protected IdGenerator getIdObj(){
        return  ids[random.nextInt(count)];
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