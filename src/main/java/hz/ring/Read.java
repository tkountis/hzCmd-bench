package hz.ring;

import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.ringbuffer.ReadResultSet;
import com.hazelcast.ringbuffer.Ringbuffer;
import hz.ring.base.RingBench;

import java.util.concurrent.ExecutionException;

public class Read extends RingBench {

    public int pauseForEvents=30000;
    public int timeOutMillis=50;
    private long[] readPerRing;
    private long[] seqs;

    public void init() throws Exception{
        super.init();
        readPerRing = new long[count];
        seqs = new long[count];

        for (int i = 0; i < rings.length; i++) {
            seqs[i] = getRingBuffer(i).headSequence();
        }
    }

    public void timeStep() throws InterruptedException, ExecutionException {

        int idx = random.nextInt(count);
        Ringbuffer ringBuffer = getRingBuffer(idx);

        ICompletableFuture<ReadResultSet<Object>> res = ringBuffer.readManyAsync(seqs[idx], 1, 5, null);
        ReadResultSet<Object> objects = res.get();

        seqs[idx]+=objects.readCount();
    }

    public void postPhase() {

        for (int i = 0; i < rings.length; i++) {
            Ringbuffer r = getRingBuffer(i);
            hzInstance.getAtomicLong(r.getName()+"-read").addAndGet(readPerRing[i]);
        }
    }
}
