package hz.latch;

import hz.latch.base.LatchBench;

public class CreateDestroy extends LatchBench {
    public void timeStep() {
        latch = hzInstance.getCountDownLatch(""+random.nextInt());
        latch.destroy();
    }
}
