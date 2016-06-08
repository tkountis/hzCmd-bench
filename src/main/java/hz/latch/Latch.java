package hz.latch;

import hz.latch.base.LatchBench;

public class Latch extends LatchBench {

    public void timeStep() {
        getLatch().countDown();
    }
}
