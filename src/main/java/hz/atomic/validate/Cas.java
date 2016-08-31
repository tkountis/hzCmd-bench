package hz.atomic.validate;

import hz.atomic.base.AtomicValidate;

public class Cas extends AtomicValidate {

    private int incCount=0;

    public void timeStep() {
        long val = atomic.get();
        atomic.compareAndSet(val, ++val);
        incCount++;
    }

    public void postPhase() {
        totalInc.addAndGet(incCount);
    }
}
