package hz.lock;

import com.hazelcast.core.ILock;
import hz.lock.base.LockBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends LockBench {
    public void timeStep() {
        ILock lock = hzInstance.getLock(name+random.nextInt());
        lock.destroy();
    }
}
