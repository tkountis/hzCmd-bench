package hz.executor.durable.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.durableexecutor.DurableExecutorService;

import java.util.Random;


public abstract class ExecutorBench extends BasicBenchBase {

    public String name="executor";
    public int count=1;

    private DurableExecutorService[] executors;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        executors = new DurableExecutorService[count];
        for(int i=0; i< count; i++){
            executors[i]=hzInstance.getDurableExecutorService(name+i);
        }
    }

    protected DurableExecutorService getExecutor(){
        return executors[random.nextInt(count)];
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