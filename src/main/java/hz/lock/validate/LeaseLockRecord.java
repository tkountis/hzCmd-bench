package hz.lock.validate;

import hz.lock.base.LockCheckBench;

import java.util.concurrent.TimeUnit;

public class LeaseLockRecord extends LockCheckBench {

    public long seconds=30;
    private int incCount=0;

    public void timeStep() {
        lock.lock(seconds, TimeUnit.SECONDS);
        int val = lockedMap.get(name);
        utils.Utils.sleep(5);
        lockedMap.put(name, ++val);
        incCount++;
    }

    public void cleanup() {
        totalInc.addAndGet(incCount);
    }
}
