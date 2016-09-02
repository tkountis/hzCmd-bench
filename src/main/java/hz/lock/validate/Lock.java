package hz.lock.validate;

import com.hazelcast.core.ILock;
import hz.lock.validate.base.LockValidate;

public class Lock extends LockValidate {

    private int[] increments;

    public void init() throws Exception{
        super.init();
        increments = new int[count];

        for (int i=0; i<count; i++) {
            zeroMapIdx(i);
        }
    }

    public void timeStep() {
        int i = random.nextInt(count);
        ILock lock = getLock(i);
        lock.lock();
        try {
            incMapIdx(i);
            increments[i]++;
        }finally {
            lock.unlock();
        }
    }

    public void postPhase() {
        for (int i=0; i<count; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}
