package hz.latch;

import com.hazelcast.core.ICountDownLatch;
import hz.latch.base.LatchBench;

public class CreateDestroy extends LatchBench {
    public void timeStep() {
        ICountDownLatch latch = hzInstance.getCountDownLatch(name+random.nextInt());
        latch.destroy();
    }
}
