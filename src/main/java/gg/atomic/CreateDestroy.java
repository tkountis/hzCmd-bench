package gg.atomic;

import gg.atomic.base.AtomicBench;

public class CreateDestroy extends AtomicBench {
    public void timeStep() {
        atomic = ignite.atomicLong(""+random.nextInt(), 0, true);
        atomic.close();
    }
}
