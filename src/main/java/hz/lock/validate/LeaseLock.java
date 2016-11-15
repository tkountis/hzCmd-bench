package hz.lock.validate;

import com.hazelcast.core.ILock;
import hz.lock.validate.base.LockValidate;

import java.util.concurrent.TimeUnit;

public class LeaseLock extends LockValidate {

    public long seconds=10;
    private int[] increments;

    public void init() throws Exception{
        super.init();
        increments = new int[count];
    }

    public void timeStep() {

        int i = random.nextInt(count);
        ILock lock = getLock(i);

        lock.lock(seconds, TimeUnit.SECONDS);
        incMapIdx(i);
        increments[i]++;
    }

    public void postPhase() {
        for (int i=0; i<count; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}
