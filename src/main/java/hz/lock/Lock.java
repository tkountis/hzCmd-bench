package hz.lock;

import hz.lock.base.LockBench;


public class Lock extends LockBench {

    public void timeStep() {
        lock.lock();
        lock.unlock();
    }
}
