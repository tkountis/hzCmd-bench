package hz.lock.validate;

import com.hazelcast.core.ILock;
import hz.lock.validate.base.LockValidate;

public class Lock extends LockValidate {

    public int sleepMs=5;
    private int[] increments;

    public void init() throws Exception{
        super.init();
        lockedMap.put(name, 0);
        increments = new int[count];
    }

    public void timeStep() {
        int i = random.nextInt(count);
        ILock lock = getLock(i);
        lock.lock();
        try {
            int val = lockedMap.get(name+i);
            utils.Utils.sleep(sleepMs);
            lockedMap.put(name+i, ++val);
            increments[i]++;
        }finally {
            lock.unlock();
        }
    }

    public void postPhase() {
        for (int i=0; i<increments.length; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}
