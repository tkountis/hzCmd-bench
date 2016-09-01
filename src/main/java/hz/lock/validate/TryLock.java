package hz.lock.validate;

import hz.lock.validate.base.LockValidate;

public class TryLock extends LockValidate {

    public long milliseconds=50;
    private int incCount=0;

    public void timeStep() {

        /*
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
        */
    }

    public void postPhase() {
        //totalInc.addAndGet(incCount);
    }
}
