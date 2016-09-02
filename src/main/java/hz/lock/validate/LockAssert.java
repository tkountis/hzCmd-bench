package hz.lock.validate;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ILock;
import global.AssertionException;
import hz.lock.validate.base.LockValidate;

public class LockAssert extends LockValidate {

    private boolean running=true;

    public void timeStep() throws AssertionException {

        for (int i=0; i<count; i++) {
            IAtomicLong increment = getIncrementFor(i);

            String info = increment.getName()+".get()="+increment.get()+" "+lockedMap.getName()+".get("+name+i+")="+lockedMap.get(name);
            System.out.println(info);
            if(increment.get() != lockedMap.get(name+i)){
                throw new AssertionException(info);
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