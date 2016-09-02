package hz.lock.validate;

import com.hazelcast.core.ILock;
import global.AssertionException;
import hz.lock.validate.base.LockValidate;

public class LockAssert extends LockValidate {

    private boolean running=true;

    public void timeStep() throws AssertionException {

        for (int i=0; i<count; i++) {
            System.out.println(getInfoFor(i));
        }

        for (int i=0; i<count; i++) {
            if( getIncrementFor(i) != getMapIdx(i) ){
                throw new AssertionException(getInfoFor(i));
            }
        }

        for (int i=0; i<count; i++) {
            ILock lock = getLock(i);
            if(lock.isLocked()){
                throw new AssertionException(lock.getName()+" isLocked()==true");
            }
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}