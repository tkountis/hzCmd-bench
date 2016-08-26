package hz.lock.validate;

import hz.lock.base.LockCheckBench;

public class LockRecord extends LockCheckBench {

    private int incCount=0;

    public void timeStep() {
        lock.lock();
        try {
            int val = lockedMap.get(name);
            utils.Utils.sleep(5);
            lockedMap.put(name, ++val);
            incCount++;
        }finally {
            lock.unlock();
        }
    }

    public void cleanup() {
        totalInc.addAndGet(incCount);
    }
}
