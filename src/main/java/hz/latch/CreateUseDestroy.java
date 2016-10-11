package hz.latch;

import com.hazelcast.core.ICountDownLatch;
import hz.latch.base.LatchBench;

public class CreateUseDestroy extends LatchBench {

    public int max=10;

    public void timeStep() {
        ICountDownLatch latch = hzInstance.getCountDownLatch(name+random.nextInt(max));
        latch.trySetCount(Integer.MAX_VALUE);
        latch.countDown();
        latch.destroy();
    }
}
