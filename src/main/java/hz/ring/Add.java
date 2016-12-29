package hz.ring;

import com.hazelcast.ringbuffer.Ringbuffer;
import hz.ring.base.RingBench;

import java.util.concurrent.ExecutionException;

public class Add extends RingBench {

    private long[] addPerRing;

    public void init() throws Exception{
        super.init();
        addPerRing = new long[count];
    }

    public void timeStep() throws InterruptedException, ExecutionException {
        Object val = mapKeyToValue(random.nextInt(keyDomain));

        int idx = random.nextInt(count);
        Ringbuffer ringBuffer = getRingBuffer(idx);

        long res = ringBuffer.add(val);
        if (res != -1) {
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
