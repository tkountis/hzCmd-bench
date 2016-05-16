package gg.atomic;

import gg.atomic.base.AtomicBench;


public class Get extends AtomicBench {

    public void timeStep() {
        atomic.get();
    }
}
