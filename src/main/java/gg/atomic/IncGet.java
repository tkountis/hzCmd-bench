package gg.atomic;

import gg.atomic.base.AtomicBench;


public class IncGet extends AtomicBench {

    public void timeStep() {
        atomic.incrementAndGet();
    }
}
