package hz.lock.validate;

import hz.lock.base.LockValidate;

public class Lock extends LockValidate {

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

    public void postPhase() {
        totalInc.addAndGet(incCount);
    }
}
