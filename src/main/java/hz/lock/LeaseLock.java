package hz.lock;

import com.hazelcast.core.ILock;
import hz.lock.base.LockBench;

import java.util.concurrent.TimeUnit;


public class LeaseLock extends LockBench {

    public long milliSeconds=50;

    public void timeStep() {
        ILock lock = getLock();
        lock.lock(milliSeconds, TimeUnit.MILLISECONDS);
    }
}
