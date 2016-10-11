package hz.lock;

import com.hazelcast.core.ILock;
import hz.lock.base.LockBench;

import java.util.concurrent.TimeUnit;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateUseDestroy extends LockBench {

    public int max=10;

    public void timeStep() {
        ILock lock = hzInstance.getLock(name+random.nextInt(max));
        try {
            lock.tryLock(25, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.destroy();
    }
}
