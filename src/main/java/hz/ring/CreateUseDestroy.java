package hz.ring;

import com.hazelcast.ringbuffer.Ringbuffer;
import hz.ring.base.RingBench;

public class CreateUseDestroy extends RingBench {

    public int max=10;

    public void timeStep() {
        Ringbuffer ringbuffer = hzInstance.getRingbuffer(name+random.nextInt(max));
        int k = random.nextInt(keyDomain);
        Object val = mapKeyToValue(k);
        ringbuffer.add(val);
        ringbuffer.destroy();
    }
}
