package hz.latch.validate;

import hz.latch.base.LatchCheckBench;

import java.util.concurrent.TimeUnit;

public class LatchCheck extends LatchCheckBench {

    private int latchedCount=0;

    public void timeStep() throws InterruptedException {
        latch.countDown();
        latch.await(30, TimeUnit.MINUTES);
        latch.trySetCount(latchValue);
        latchedCount++;
    }

    public void postPhase() {
        System.out.println(latch.getName()+" latchedCount="+latchedCount);
    }
}
