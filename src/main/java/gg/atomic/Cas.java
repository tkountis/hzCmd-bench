package gg.atomic;

import gg.atomic.base.AtomicBench;


public class Cas extends AtomicBench {

    public void timeStep() {
        long val = atomic.get();
        atomic.compareAndSet(val, ++val);
    }
}
