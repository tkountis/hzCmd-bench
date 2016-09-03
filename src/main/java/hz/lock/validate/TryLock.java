package hz.lock.validate;

import com.hazelcast.core.ILock;
import hz.lock.validate.base.LockValidate;

import java.util.concurrent.TimeUnit;

public class TryLock extends LockValidate {

    public long milliseconds=50;
    private int[] increments;

    public void init() throws Exception{
        super.init();
        increments = new int[count];

        for (int i=0; i<count; i++) {
            zeroMapIdx(i);
        }
    }

    public void timeStep() {
        try {
            int i = random.nextInt(count);
            ILock lock = getLock(i);
            if( lock.tryLock(milliseconds, TimeUnit.MILLISECONDS) ){
                try {
                    incMapIdx(i);
                    increments[i]++;
                }finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) { }
    }

    public void postPhase() {
        for (int i=0; i<count; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}
