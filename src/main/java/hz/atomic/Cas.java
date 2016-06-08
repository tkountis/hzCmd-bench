package hz.atomic;

import com.hazelcast.core.IAtomicLong;
import hz.atomic.base.AtomicBench;


public class Cas extends AtomicBench{

    public void timeStep() {
        IAtomicLong atomic = getAtomic();
        long val = atomic.get();
        atomic.compareAndSet(val, ++val);
    }
}
