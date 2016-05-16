package gg.atomic;

import gg.atomic.base.AtomicMultiBench;


public class MultiIncGet extends AtomicMultiBench{

    public void timeStep() {
        int i=random.nextInt(atomicCount);
        ignite.atomicLong(i+name, 0, true).incrementAndGet();
    }
}
