package hz.lock.validate;

import global.AssertionException;
import hz.lock.base.LockCheckBench;

public class LockCheck extends LockCheckBench {

    private boolean running=true;

    public void timeStep() throws AssertionException {
        if(totalInc.get() != lockedMap.get(name)){
            throw new AssertionException(totalInc.getName()+" "+totalInc.get()+" != "+lockedMap.getName()+" "+" "+lockedMap.get(name));
        }
        if(lock.isLocked()){
            throw new AssertionException(lock.getName()+" isLocked()==true");
        }
        running=false;
    }

    public void cleanup() {
        lock.destroy();
        lockedMap.destroy();
        totalInc.destroy();
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}