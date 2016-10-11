package hz.queue;

import com.hazelcast.core.IQueue;
import hz.queue.base.QueueBench;

import java.util.concurrent.TimeUnit;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateUseDestroy extends QueueBench {

    public int max=10;
    public int timeOutMillis=25;

    public void timeStep() {
        IQueue queue = hzInstance.getQueue(name+random.nextInt(max));
        Object val = mapKeyToValue(random.nextInt(keyDomain));
        try {
            queue.offer(val, timeOutMillis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.destroy();
    }
}
