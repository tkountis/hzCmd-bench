package hz.executor.regular.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

import java.util.Random;


public abstract class ExecutorBench extends BasicBenchBase {

    public String name="executor";
    public int count=1;

    private IExecutorService[] executors;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        executors = new IExecutorService[count];
        for(int i=0; i< count; i++){
            executors[i]=hzInstance.getExecutorService(name+i);
        }
    }

    protected IExecutorService getExecutor(){
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