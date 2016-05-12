package hz.atomic;

import hz.atomic.base.AtomicBench;


public class Get extends AtomicBench{

    public void timeStep() {
        atomic.get();
    }
}
