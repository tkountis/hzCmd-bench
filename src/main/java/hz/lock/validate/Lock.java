package hz.lock.validate;

import hz.lock.base.LockValidate;

public class Lock extends LockValidate {

    private int incCount=0;

    public void timeStep() {
        lock.lock();
        try {
            int val = lockedMap.get(name);
            utils.Utils.sleep(5);
            val++;
            lockedMap.put(name, val);
            incCount++;
        }finally {
            lock.unlock();
        }
    }

    public void postPhase() {
        System.out.println("incCount="+incCount);
        System.out.println("map "+lockedMap.getName()+" lockedMap.get("+name+")="+lockedMap.get(name));
        totalInc.addAndGet(incCount);
    }
}
