package hz.atomic.validate;

import hz.atomic.base.AtomicTest;

public class CasRecord extends AtomicTest {

    private int incCount=0;

    public void timeStep() {
        long val = atomic.get();
        atomic.compareAndSet(val, ++val);
        incCount++;
    }

    public void cleanup() {
        totalInc.addAndGet(incCount);
    }
}
