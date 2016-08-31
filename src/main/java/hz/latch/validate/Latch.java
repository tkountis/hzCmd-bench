package hz.latch.validate;

import hz.latch.base.LatchValidate;

import java.util.concurrent.TimeUnit;

public class Latch extends LatchValidate {

    private int latchedCount=0;

    public void timeStep() throws InterruptedException {
        latch.countDown();
        latch.await(30, TimeUnit.MINUTES);
        latch.trySetCount(latchValue);
        latchedCount++;
    }

    public void postPhase() {
        latchCounts.add(latchedCount);
        System.out.println(latch.getName()+" latchedCount="+latchedCount);
    }
}
