package hz.atomic;

import hz.atomic.base.AtomicBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends AtomicBench{
    public void timeStep() {
        atomic = hzInstance.getAtomicLong(""+random.nextInt());
        atomic.destroy();
    }
}
