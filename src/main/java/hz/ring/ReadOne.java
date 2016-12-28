package hz.ring;

import com.hazelcast.ringbuffer.Ringbuffer;
import hz.ring.base.RingBench;

import java.util.concurrent.ExecutionException;

public class ReadOne extends RingBench {

    private long[] readPerRing;

    public void init() throws Exception{
        super.init();
        readPerRing = new long[count];
    }

    public void timeStep() throws InterruptedException, ExecutionException {
        int idx = random.nextInt(count);
        Ringbuffer ringBuffer = getRingBuffer(idx);
        Object res = ringBuffer.readOne(ringBuffer.tailSequence());
        readPerRing[idx]++;
    }

    public void postPhase() {

        for (int i = 0; i < rings.length; i++) {
            Ringbuffer r = getRingBuffer(i);
            hzInstance.getAtomicLong(r.getName()+"-read").addAndGet(readPerRing[i]);
        }
    }
}
