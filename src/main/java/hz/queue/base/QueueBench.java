package hz.queue.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public abstract class QueueBench extends BenchBase {

    public int count=1;
    protected IQueue<Object>[] queues;
    protected HazelcastInstance hzInstance;

    public void init() throws Exception{
        super.init();
        queues = new IQueue[count];
        for (int i = 0; i < count; i++) {
            queues[i] = hzInstance.getQueue(name+i);
        }
    }

    public IQueue getRandomQueue(){
        return getQueue(random.nextInt(count));
    }

    public IQueue getQueue(int i){
        return queues[i];
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    @Override
    public String toString() {
        return super.toString() + " QueueBench{" + "hzInstance=" + hzInstance + ", queues=" + queues + '}';
    }
}