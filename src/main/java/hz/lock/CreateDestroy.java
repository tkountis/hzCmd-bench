package hz.lock;

import hz.lock.base.LockBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends LockBench {
    public void timeStep() {
        lock = hzInstance.getLock(""+random.nextInt());
        lock.destroy();
    }
}
