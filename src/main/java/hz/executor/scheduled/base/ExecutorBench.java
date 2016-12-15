package hz.executor.scheduled.base;


import base.BasicBenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.scheduledexecutor.IScheduledExecutorService;

import java.util.Random;

public abstract class ExecutorBench extends BasicBenchBase {

    public String name="scheduledExecutor";
    public int executorCount=1;

    private IScheduledExecutorService[] executors;
    protected HazelcastInstance hzInstance;
    protected Random random = new Random();

    public void init() throws Exception{
        super.init();

        executors = new IScheduledExecutorService[executorCount];
        for(int i=0; i< executorCount; i++){
            executors[i] = hzInstance.getScheduledExecutorService(name + i);
        }
    }

    protected IScheduledExecutorService getExecutor(int i){ return executors[i]; }

    protected IScheduledExecutorService getExecutor(){
        return executors[random.nextInt(executorCount)];
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