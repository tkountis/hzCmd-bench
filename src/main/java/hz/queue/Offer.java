package hz.queue;

import com.hazelcast.core.IQueue;
import hz.queue.base.QueueBench;

import java.util.concurrent.TimeUnit;

public class Offer extends QueueBench {


    public int timeOutMillis=10;
    private long[] offerPerQ;

    public void init() throws Exception{
        super.init();
        offerPerQ = new long[count];
    }

    public void timeStep() throws InterruptedException {
        Object val = mapKeyToValue(random.nextInt(keyDomain));

        int queueIdx = random.nextInt(count);
        IQueue q = getQueue(queueIdx);


        if( q.offer(val, timeOutMillis, TimeUnit.MILLISECONDS) ){
            offerPerQ[queueIdx]++;
        }
    }


    public void postPhase() {

        for (int i = 0; i < queues.length; i++) {
            IQueue q = getQueue(i);
            hzInstance.getAtomicLong(q.getName()+"-offer").addAndGet(offerPerQ[i]);
        }
    }
}
