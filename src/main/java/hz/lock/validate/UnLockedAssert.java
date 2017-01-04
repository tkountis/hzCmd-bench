package hz.lock.validate;

import com.hazelcast.core.ILock;
import global.AssertionException;
import hz.lock.base.LockBench;

public class UnLockedAssert extends LockBench {

    public int pauseMillis=30000;

    public void timeStep() throws AssertionException {

        utils.Utils.sleep(pauseMillis);

        for (int i=0; i<count; i++) {
            ILock lock = getLock(i);
            if(lock.isLocked()){
                throw new AssertionException(lock.getName()+".isLocked()==true");
            }
        }

        setRunning(false);
    }
}