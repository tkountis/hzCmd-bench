package hz.atomic;

import hz.atomic.base.AtomicCheckBench;

public class CasRecord extends AtomicCheckBench {

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
