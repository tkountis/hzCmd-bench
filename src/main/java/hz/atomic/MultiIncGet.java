package hz.atomic;

import hz.atomic.base.AtomicMultiBench;


public class MultiIncGet extends AtomicMultiBench{

    public void timeStep() {
        int i=random.nextInt(atomicCount);
        hzInstance.getAtomicLong(i+name).incrementAndGet();
    }
}
