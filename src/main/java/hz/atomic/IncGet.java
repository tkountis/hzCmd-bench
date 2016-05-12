package hz.atomic;

import hz.atomic.base.AtomicBench;


public class IncGet extends AtomicBench{

    public void timeStep() {
        atomicLong.incrementAndGet();
    }
}
