package hz.lock.validate;

import hz.lock.base.LockCheckBench;

import java.util.concurrent.TimeUnit;

public class TryLockRecord extends LockCheckBench {

    public long milliseconds=50;
    private int incCount=0;

    public void timeStep() {
        try {
            if( lock.tryLock(milliseconds, TimeUnit.MILLISECONDS) ){
                try {
                    int val = lockedMap.get(name);
                    utils.Utils.sleep(5);
                    lockedMap.put(name, ++val);
                    incCount++;
                }finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) { }
    }

    public void cleanup() {
        totalInc.addAndGet(incCount);
    }
}
