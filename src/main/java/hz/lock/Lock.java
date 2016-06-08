package hz.lock;

import com.hazelcast.core.ILock;
import hz.lock.base.LockBench;


public class Lock extends LockBench {

    public void timeStep() {
        ILock lock = getLock();
        lock.lock();
        lock.unlock();
    }
}
