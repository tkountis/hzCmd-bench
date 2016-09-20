package gg.atomic;

import gg.atomic.base.AtomicBench;
import org.apache.ignite.IgniteAtomicLong;

public class Cas extends AtomicBench {

    public void timeStep() {
        IgniteAtomicLong atomic = getAtomic();
        long val = atomic.get();
        atomic.compareAndSet(val, ++val);
    }
}
