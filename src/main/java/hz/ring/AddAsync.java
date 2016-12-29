package hz.ring;

import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.ringbuffer.OverflowPolicy;
import com.hazelcast.ringbuffer.Ringbuffer;
import hz.ring.base.RingBench;

import java.util.concurrent.ExecutionException;

public class AddAsync extends RingBench {

    private long[] addPerRing;

    public void init() throws Exception{
        super.init();
        addPerRing = new long[count];
    }

    public void timeStep() throws InterruptedException, ExecutionException {
        Object val = mapKeyToValue(random.nextInt(keyDomain));

        int idx = random.nextInt(count);
        Ringbuffer ringBuffer = getRingBuffer(idx);

        ICompletableFuture<Long> res = ringBuffer.addAsync(val, OverflowPolicy.FAIL);
        if (res.get() != -1) {
            addPerRing[idx]++;
        }
    }


    public void postPhase() {

        for (int i = 0; i < rings.length; i++) {
            Ringbuffer r = getRingBuffer(i);
            hzInstance.getAtomicLong(r.getName()+"-add").addAndGet(addPerRing[i]);
        }
    }
}
